package com.task.domain.usecase.whether.stations

import com.task.common.model.station.Station
import com.task.common.model.user.User
import kotlinx.coroutines.flow.Flow

interface StationsUseCase {
    suspend operator fun invoke(distance:Double,lat:Double,lng:Double): Flow<List<Station?>?>
}
