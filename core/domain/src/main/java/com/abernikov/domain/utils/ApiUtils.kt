package com.abernikov.domain.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

object ApiUtils {

    private const val MAX_RETRY_COUNT = 3
    private const val DELAY_BETWEEN_RETRIES = 200L

    fun getRequestStatusError(code: Int, message: String?): RequestStatus.Error {
        return when (code) {
            400 -> {
                RequestStatus.Error(ApiException.BadRequest(code, message))
            }

            401 -> {
                RequestStatus.Error(ApiException.Unauthorized(code, message))
            }

            404 -> {
                RequestStatus.Error(ApiException.NotFoundException(code, message))
            }

            in 500..599 -> {
                RequestStatus.Error(
                    ApiException.InternalServerError(code, message)
                )
            }

            else -> {
                RequestStatus.Error(ApiException.Unknown(code, message))
            }
        }
    }

    fun getRequestStatusError(throwable: Throwable): RequestStatus.Error {
        return when (throwable) {
            is IOException -> {
                RequestStatus.Error(ApiException.NetworkProblem(throwable))
            }

            else -> {
                RequestStatus.Error(ApiException.RuntimeError(throwable))
            }
        }
    }

    suspend fun <T : Any> apiCall(
        retryable: Boolean = true,
        maxRetryCount: Int = MAX_RETRY_COUNT,
        delayBetweenRetries: Long = DELAY_BETWEEN_RETRIES,
        request: suspend () -> Response<T>
    ): RequestStatus<T> {
        val response: Response<T> = try {
            withContext(Dispatchers.IO) {
                request.invoke()
            }
        } catch (ex: Throwable) {
            val requestStatusError = getRequestStatusError(ex)

            if (!retryable || !getIsThrowableRetryable(requestStatusError.apiException)) {
                return requestStatusError
            } else {
                var requestStatus: RequestStatus<T>? = null

                repeat(maxRetryCount) {
                    requestStatus = apiCall(retryable = false, request = request)

                    if (requestStatus is RequestStatus.Success) {
                        return requestStatus as RequestStatus<T>
                    }
                    delay(delayBetweenRetries)
                }

                return requestStatus!!
            }
        }

        return if (response.isSuccessful) {
            RequestStatus.Success(response.body())
        } else getRequestStatusError(response.code(), response.message())
    }

    private fun getIsThrowableRetryable(apiException: ApiException): Boolean {
        return apiException is ApiException.NetworkProblem &&
                apiException.throwable is IOException
    }
}