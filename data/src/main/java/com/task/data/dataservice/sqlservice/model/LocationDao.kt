package com.task.data.dataservice.sqlservice.model

data class LocationDao(
    val country: String,
    val city: String,
    val street: StreetDao,
    val timezone: TimezoneDao,
    val postcode: String,
    val coordinates: CoordinatesDao,
    val state: String
)

