package com.task.data.dataservice.apiservice

import com.task.data.model.response.GetUsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface UserApiService {
    @GET("api")
    suspend fun getUsersList(
        @Query("seed") seed: String = "renderforest",
        @Query("results") results: Int,
        @Query("page") page: Int
    ): GetUsersResponse
}