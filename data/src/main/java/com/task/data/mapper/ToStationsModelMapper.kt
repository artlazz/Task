package com.task.data.mapper

import com.task.common.model.stations.Stations
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.response.StationsResponse

class ToStationsModelMapper : BaseMapper<StationsResponse, Stations> {
    override fun invoke(response: StationsResponse): Stations {
        return Stations(
            longitude = response.longitude,
            latitude = response.latitude,
            name = response.name,
            source = response.source
        )
    }
}