package com.task.data.repositories.whether

import com.task.common.model.extrems.Extremes
import com.task.common.model.sealevel.SeaLevel
import com.task.common.model.station.Station
import com.task.data.dataservice.apiservice.WhetherApiService
import com.task.data.executor.ServiceExecutor
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.request.RequestParams
import com.task.data.model.response.Data
import com.task.data.model.response.ExtremesData
import com.task.data.model.response.SeaLevelData
import com.task.domain.repository.WhetherRepo
import kotlinx.coroutines.flow.Flow

internal class WhetherRepoImpl(
    private val serviceExecutor: ServiceExecutor,
    private val whetherApiService: WhetherApiService,
    private val toStationsModelMapper: BaseMapper<Data?, Station?>,
    private val toExtremesModelMapper: BaseMapper<ExtremesData?, Extremes?>,
    private val toSeaLevelModelMapper: BaseMapper<SeaLevelData?, SeaLevel?>

) : WhetherRepo {

    override suspend fun getStations(): Flow<List<Station?>?> =
        serviceExecutor.execute {
            whetherApiService.getStations().data?.map { toStationsModelMapper(it) }
        }

    override suspend fun getExtremes(lat:Double?,lng:Double?,start:Long?,end:Long?):Flow<List<Extremes?>?> =
        serviceExecutor.execute {
            whetherApiService.getExtremes(RequestParams(lat,lng,start,end)).extremesData?.map { toExtremesModelMapper(it) }
        }

    override suspend fun getSealevel(lat:Double?,lng:Double?,start:Long?,end:Long?):Flow<List<SeaLevel?>?> =
        serviceExecutor.execute {
            whetherApiService.getSeaLevel(RequestParams(lat,lng,start,end)).data?.map { toSeaLevelModelMapper(it) }
        }
}
