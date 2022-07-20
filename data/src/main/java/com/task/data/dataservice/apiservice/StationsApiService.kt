package com.task.data.dataservice.apiservice

import com.task.data.model.response.StationsResponse
import retrofit2.http.GET

interface StationsApiService {
    @GET("v2/tide/stations")
    fun fetchStations(): StationsResponse
}