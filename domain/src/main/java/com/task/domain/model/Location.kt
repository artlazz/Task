package com.task.domain.model

data class Location(
    val country: String,
    val city: String,
    val street: Street,
    val timezone: Timezone,
    val postcode: String,
    val coordinates: Coordinates,
    val state: String
)

