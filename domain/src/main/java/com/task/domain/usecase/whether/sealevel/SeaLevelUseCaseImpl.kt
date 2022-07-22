package com.task.domain.usecase.whether.sealevel

import com.task.common.model.sealevel.SeaLevel
import com.task.domain.repository.WhetherRepo
import kotlinx.coroutines.flow.Flow

class SeaLevelUseCaseImpl(
    private val whetherRepo: WhetherRepo
) : SeaLevelUseCase {

    override suspend fun invoke(lat: Double?, lng: Double?, start: Long?, end: Long?): Flow<List<SeaLevel?>?> =
        whetherRepo.getSealevel(lat, lng, start, end)
}
