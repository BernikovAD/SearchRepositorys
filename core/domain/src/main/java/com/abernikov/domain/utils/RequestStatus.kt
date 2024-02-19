package com.abernikov.domain.utils

sealed class RequestStatus<out T>(val data: T?, val message: String?) {

    data class Success<out R>(private val _data: R?) : RequestStatus<R>(
        data = _data,
        message = null
    )

    data class Error(val apiException: ApiException) : RequestStatus<Nothing>(
        data = null,
        message = null
    )
}