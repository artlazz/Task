package com.task.data.repositories.stations

import com.task.common.model.stations.Stations
import com.task.data.dataservice.apiservice.StationsApiService
import com.task.data.executor.ServiceExecutor
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.response.StationsResponse
import com.task.domain.repository.StationsRepository
import kotlinx.coroutines.flow.Flow

internal class StationsRepositoryImpl(
    private val serviceExecutor: ServiceExecutor,
    private val stationsApiService: StationsApiService,
    private val toStationsModelMapper: BaseMapper<StationsResponse, Stations>
) : StationsRepository {
    override suspend fun fetchStationsList(): Flow<List<Stations>> =
        serviceExecutor.execute {
            stationsApiService.fetchStations().map {
                toStationsModelMapper(
                    it
                )
//                Stations(
//                    longitude = it.longitude,
//                    latitude = it.latitude,
//                    name = it.name,
//                    source = it.source
//                )
            }
        }
}