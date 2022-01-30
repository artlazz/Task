package com.task.data

sealed class NetworkError : AppError {
    object ServerInternal : NetworkError()
    object Connection : NetworkError()
    object Conflict : NetworkError()
    object BadRequest : NetworkError()
}