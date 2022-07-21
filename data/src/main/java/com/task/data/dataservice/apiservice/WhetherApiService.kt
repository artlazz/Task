package com.task.data.dataservice.apiservice

import com.task.data.model.response.StationsResponse
import retrofit2.http.GET
import retrofit2.http.POST

internal interface WhetherApiService {
    @GET("tide/stations")
    suspend fun getStations(): StationsResponse
}