package com.task.data.providers

import com.task.data.model.request.LoginRequest

class LoginRequestProvider : (String, String) -> LoginRequest {
    override fun invoke(username: String, password: String) = LoginRequest(username, password)
}