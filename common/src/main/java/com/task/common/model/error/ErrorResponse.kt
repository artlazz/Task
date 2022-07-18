package com.task.common.model.error

data class ErrorResponse(
    val name: String,
    val errorMessage: String,
    val code: Int,
    val status: Int,
    val type: String
) : Exception() {
    constructor(message: String) : this("", message.ifBlank { "Error" }, 0, 0, "")
}
