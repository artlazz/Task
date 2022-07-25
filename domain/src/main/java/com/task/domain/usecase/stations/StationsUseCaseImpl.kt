package com.task.domain.usecase.stations

import com.task.common.model.stations.Stations
import com.task.domain.repository.StationsRepository
import kotlinx.coroutines.flow.Flow

class StationsUseCaseImpl(
    private val stationsRepository: StationsRepository
) : StationsUseCase {
    override suspend fun fetchStations(): Flow<List<Stations>> = stationsRepository.fetchStationsList()
}