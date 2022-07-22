package com.task.domain.repository

import com.task.common.model.extrems.Extremes
import com.task.common.model.sealevel.SeaLevel
import com.task.common.model.station.Station
import kotlinx.coroutines.flow.Flow

interface WhetherRepo {
    suspend fun getStations(): Flow<List<Station?>?>
    suspend fun getExtremes(lat:Double?,lng:Double?,start:Long?,end:Long?):Flow<List<Extremes?>?>
    suspend fun getSealevel(lat:Double?,lng:Double?,start:Long?,end:Long?):Flow<List<SeaLevel?>?>
}