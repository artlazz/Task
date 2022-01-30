package com.task.data.executor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class ServiceExecutor {
    suspend fun <T> execute(block: suspend () -> T): T =
        withContext(Dispatchers.IO) {
            try {
                block()
            } catch (e: Exception) {
                throw java.lang.Exception(e.message)
            }
        }
}