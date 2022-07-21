package com.task.data.repositories.whether

import com.task.common.model.station.Station
import com.task.data.dataservice.apiservice.WhetherApiService
import com.task.data.executor.ServiceExecutor
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.response.Data
import com.task.domain.repository.WhetherRepo
import kotlinx.coroutines.flow.Flow

internal class WhetherRepoImpl(
    private val serviceExecutor: ServiceExecutor,
    private val whetherApiService: WhetherApiService,
    private val toStationsModelMapper: BaseMapper<Data?, Station?>
) : WhetherRepo {

    override suspend fun getStations(): Flow<List<Station?>?> =
        serviceExecutor.execute {
            whetherApiService.getStations().data?.map { toStationsModelMapper(it) }
        }
}
