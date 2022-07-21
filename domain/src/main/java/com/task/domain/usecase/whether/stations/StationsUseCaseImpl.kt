package com.task.domain.usecase.whether.stations

import com.task.common.model.station.Station
import com.task.domain.repository.WhetherRepo
import com.task.domain.utils.distanceInKm
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapLatest

class StationsUseCaseImpl(
    private val whetherRepo: WhetherRepo
) : StationsUseCase {

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun invoke(distance: Double, lat: Double, lng: Double): Flow<List<Station?>?> =
        whetherRepo.getStations().filter {
            !it.isNullOrEmpty() }.mapLatest { stations ->
                stations?.filter { station ->
                    distanceInKm(lat, lng, station?.lat, station?.lng) <= distance
                }
            }
}
