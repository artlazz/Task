package com.task.data.model.response


import com.squareup.moshi.Json

data class SeaLevelDto(
    @Json(name = "data")
    val data: List<SeaLevelData?>?,
    @Json(name = "meta")
    val meta: SeaLevelMeta?
)

data class SeaLevelData(
    @Json(name = "sg")
    val sg: Double?,
    @Json(name = "time")
    val time: String?
)

data class SeaLevelMeta(
    @Json(name = "cost")
    val cost: Int?,
    @Json(name = "dailyQuota")
    val dailyQuota: Int?,
    @Json(name = "datum")
    val datum: String?,
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
    val station: SeaLevelStation?
)

data class SeaLevelStation(
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
