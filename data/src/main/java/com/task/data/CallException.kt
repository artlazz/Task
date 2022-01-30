package com.task.data

class CallException(
    errorMessage: String? = null,
    val error: AppError
) : Exception(errorMessage) {
    constructor(error: AppError) : this(null, error)
}