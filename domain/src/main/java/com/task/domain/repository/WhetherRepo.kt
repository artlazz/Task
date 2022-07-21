package com.task.domain.repository

import com.task.common.model.station.Station
import kotlinx.coroutines.flow.Flow

interface WhetherRepo {
    suspend fun getStations(): Flow<List<Station?>?>
}