package com.task.domain.usecase.whether.extremes

import com.task.common.model.extrems.Extremes
import com.task.common.model.station.Station
import com.task.domain.repository.WhetherRepo
import com.task.domain.utils.distanceInKm
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapLatest

class ExtremesUseCaseImpl(
    private val whetherRepo: WhetherRepo
) : ExtremesUseCase {

    override suspend fun invoke(lat:Double?,lng:Double?,start:Long?,end:Long?):Flow<List<Extremes?>?> =
        whetherRepo.getExtremes(lat,lng,start,end)
}
