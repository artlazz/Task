package com.task.data.dataservice.apiservice

import com.task.data.model.request.LoginRequest
import com.task.data.model.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface UserApiService {
    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest // replace with request object
    ): UserResponse // replace with response object
}