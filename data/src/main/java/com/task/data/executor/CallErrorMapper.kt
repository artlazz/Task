package com.task.data.executor


import com.task.data.AppError
import com.task.data.NetworkError.*
import com.task.data.Unknown
import retrofit2.HttpException
import java.io.IOException

private const val HTTP_CODE_BAD_REQUEST = 400
private const val HTTP_CODE_CONFLICT = 409
private const val HTTP_CODE_INTERNAL_SERVER_ERROR = 500
private const val HTTP_CODE_SERVICE_UNAVAILABLE = 503

class CallErrorMapper : (Exception) -> AppError {

    override fun invoke(error: Exception): AppError {
        return when (error) {
            is HttpException -> mapHttpCodeError(error)
            is IOException -> Connection
            else -> Unknown
        }
    }

    private fun mapHttpCodeError(httpException: HttpException) = when (httpException.code()) {
        HTTP_CODE_INTERNAL_SERVER_ERROR -> ServerInternal
        HTTP_CODE_CONFLICT -> Conflict
        HTTP_CODE_BAD_REQUEST -> BadRequest
        HTTP_CODE_SERVICE_UNAVAILABLE -> Connection
        else -> Unknown
    }
}