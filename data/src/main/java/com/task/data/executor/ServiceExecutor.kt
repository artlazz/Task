package com.task.data.executor

import com.task.data.AppError
import com.task.data.CallException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class ServiceExecutor(
    private val errorMapper: (Exception) -> AppError
) {
    suspend fun <T> execute(block: suspend () -> T): T =
        withContext(Dispatchers.IO) {
            try {
                block()
            } catch (e: Exception) {
                throw CallException(e.message, errorMapper(e))
            }
        }
}