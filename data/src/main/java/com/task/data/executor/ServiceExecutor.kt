package com.task.data.executor

import com.task.common.model.error.ErrorResponse
import com.task.data.mapper.base.BaseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class ServiceExecutor(
    private val requestExceptionToErrorMapper: BaseMapper<Throwable, ErrorResponse>
) {
    fun <Result> execute(action: suspend () -> Result) = flow {
        emit(action())
    }.catch {
        throw requestExceptionToErrorMapper(it)
    }.flowOn(Dispatchers.IO)
}