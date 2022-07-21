package com.task.data.model.response

import com.squareup.moshi.Json

data class StationsResponse(
    @Json(name="data")
    val data: List<Data?>?,
    @Json(name="meta")
    val meta: Meta?
)
    data class Data(
        @Json(name="lat")
        val lat: Double?,
        @Json(name="lng")
        val lng: Double?,
        @Json(name="name")
        val name: String?,
        @Json(name="source")
        val source: String?
    )

    data class Meta(
        @Json(name="cost")
        val cost: Int?,
        @Json(name="dailyQuota")
        val dailyQuota: Int?,
        @Json(name="requestCount")
        val requestCount: Int?
    )
