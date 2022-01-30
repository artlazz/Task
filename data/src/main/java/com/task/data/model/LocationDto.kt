package com.task.data.model

data class LocationDto(
    val country: String? = null,
    val city: String? = null,
    val street: StreetDto? = null,
    val timezone: TimezoneDto? = null,
    val postcode: String? = null,
    val coordinates: CoordinatesDto? = null,
    val state: String? = null
)

