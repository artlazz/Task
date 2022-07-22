package com.task.domain.usecase.whether.extremes

import com.task.common.model.extrems.Extremes
import com.task.common.model.station.Station
import com.task.common.model.user.User
import kotlinx.coroutines.flow.Flow

interface ExtremesUseCase {
    suspend operator fun invoke(lat:Double?,lng:Double?,start:Long? = null,end:Long? = null):Flow<List<Extremes?>?>
}
