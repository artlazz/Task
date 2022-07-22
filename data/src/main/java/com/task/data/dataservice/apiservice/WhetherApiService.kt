package com.task.data.dataservice.apiservice

import com.task.data.model.request.RequestParams
import com.task.data.model.response.ExtremesDto
import com.task.data.model.response.SeaLevelDto
import com.task.data.model.response.StationsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

internal interface WhetherApiService {
    @GET("tide/stations")
    suspend fun getStations(): StationsResponse

    @GET("tide/extremes/point")
    suspend fun getExtremes(@Body() requestParams: RequestParams): ExtremesDto

    @GET("tide/sea-level/point")
    suspend fun getSeaLevel(@Body() requestParams: RequestParams): SeaLevelDto
}