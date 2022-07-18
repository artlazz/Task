package com.task.data.mapper.error

import com.task.common.model.error.ErrorResponse
import com.task.data.mapper.base.BaseMapper
import retrofit2.HttpException

class RequestExceptionToBaseErrorMapper : BaseMapper<Throwable, ErrorResponse> {
    override fun invoke(error: Throwable): ErrorResponse = when (error) {
        is HttpException -> ErrorResponse(error.response()?.message() ?: "")
        else -> ErrorResponse("error")
    }
}