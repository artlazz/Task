package com.task.domain.utils

import com.betconstruct.betcocommon.util.extentions.safeLet
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

fun distanceInKm(latt1: Double?, lonn1: Double?, latt2: Double?, lonn2: Double?): Double {
    safeLet(latt1, lonn1, latt2, lonn2) { lat1, lon1, lat2, lon2 ->
        val theta = lon1 - lon2
        var dist =
            sin(deg2rad(lat1)) * sin(deg2rad(lat2)) + cos(deg2rad(lat1)) * cos(deg2rad(lat2)) * cos(
                deg2rad(theta)
            )
        dist = acos(dist)
        dist = rad2deg(dist)
        dist *= 60 * 1.1515
        dist *= 1.609344
        return dist
    } ?: return 0.0
}


private fun deg2rad(deg: Double): Double {
    return deg * Math.PI / 180.0
}

private fun rad2deg(rad: Double): Double {
    return rad * 180.0 / Math.PI
}
