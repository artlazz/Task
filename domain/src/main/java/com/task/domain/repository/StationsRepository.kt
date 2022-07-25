package com.task.domain.repository

import com.task.common.model.stations.Stations
import kotlinx.coroutines.flow.Flow

interface StationsRepository {
    suspend fun fetchStationsList(): Flow<List<Stations>>
}