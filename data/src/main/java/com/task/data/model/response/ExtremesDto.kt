package com.task.data.model.response


import com.squareup.moshi.Json

data class ExtremesDto(
    @Json(name = "data")
    val extremesData: List<ExtremesData?>?,
    @Json(name = "meta")
    val meta: ExtremesMeta?
)

data class ExtremesData(
    @Json(name = "height")
    val height: String?,
    @Json(name = "time")
    val time: String?,
    @Json(name = "type")
    val type: String?
)

data class ExtremesMeta(
    @Json(name = "cost")
    val cost: Int?,
    @Json(name = "dailyQuota")
    val dailyQuota: Int?,
    @Json(name = "end")
    val end: String?,
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "lng")
    val lng: Double?,
    @Json(name = "requestCount")
    val requestCount: Int?,
    @Json(name = "start")
    val start: String?,
    @Json(name = "station")
    val station: Station?
)

data class Station(
    @Json(name = "distance")
    val distance: Int?,
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "lng")
    val lng: Double?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "source")
    val source: String?
)

