package com.task.data.mapper

import com.task.common.model.station.Station
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.response.Data
import com.task.data.model.response.StationsResponse

class ToStationModelMapper : BaseMapper<Data, Station> {
    override fun invoke(p1: Data): Station = Station(
        lat = p1.lat,
        lng = p1.lng,
        name = p1.source,
        source = p1.source
    )
}
