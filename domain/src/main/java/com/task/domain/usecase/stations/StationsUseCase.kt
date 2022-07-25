package com.task.domain.usecase.stations

import com.task.common.model.stations.Stations
import kotlinx.coroutines.flow.Flow

interface StationsUseCase {
    suspend fun fetchStations(): Flow<List<Stations>>
}