package com.task.data.model.response

data class LoginResponse(
    val code: String,
    val user: UserResponse
)
