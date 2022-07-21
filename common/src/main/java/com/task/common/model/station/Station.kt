package com.task.common.model.station

import java.io.Serializable

data class Station(
    val lat: Double?,
    val lng: Double?,
    val name: String?,
    val source: String?
):Serializable
