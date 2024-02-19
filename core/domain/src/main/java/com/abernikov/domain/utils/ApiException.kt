package com.abernikov.domain.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class ApiException(val code: Int?, val message: String?) : Parcelable {
    data class BadRequest(
        private val _code: Int?,
        private val _message: String?
    ) : ApiException(_code, _message)

    data class Unauthorized(
        private val _code: Int?,
        private val _message: String?
    ) : ApiException(_code, _message)

    data class InternalServerError(
        private val _code: Int?,
        private val _message: String?
    ) : ApiException(_code, _message)

    data class NetworkProblem(
        val throwable: Throwable
    ) : ApiException(null, throwable.message)

    data class NotFoundException(
        private val _code: Int?,
        private val _message: String?
    ) : ApiException(_code, _message)

    data class Unknown(
        private val _code: Int?,
        private val _message: String?
    ) : ApiException(null, _message)

    data class RuntimeError(
        val throwable: Throwable
    ) : ApiException(null, throwable.message)
}