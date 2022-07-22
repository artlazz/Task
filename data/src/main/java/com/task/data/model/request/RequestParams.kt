package com.task.data.model.request

import com.squareup.moshi.Json

data class RequestParams (
    @Json(name = "lat")
    val lat:Double?,
    @Json(name = "lng")
    val lng:Double?,
    @Json(name = "start")
    val start:Long?,
    @Json(name = "end")
    val end:Long?)