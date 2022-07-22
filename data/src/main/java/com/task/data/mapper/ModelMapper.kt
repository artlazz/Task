package com.task.data.mapper

import com.task.common.model.extrems.Extremes
import com.task.common.model.sealevel.SeaLevel
import com.task.common.model.station.Station
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.response.Data
import com.task.data.model.response.ExtremesData
import com.task.data.model.response.SeaLevelData
import java.util.*

class ToStationModelMapper : BaseMapper<Data, Station> {
    override fun invoke(p1: Data): Station = Station(
        lat = p1.lat,
        lng = p1.lng,
        name = p1.source,
        source = p1.source
    )
}

class ToExtremesModelMapper : BaseMapper<ExtremesData, Extremes> {
    override fun invoke(p1: ExtremesData): Extremes = Extremes(
        height = p1.height,
        time = Date(p1.time),
        type = p1.type
    )
}

class ToSeaLevelModelMapper : BaseMapper<SeaLevelData, SeaLevel> {
    override fun invoke(p1: SeaLevelData): SeaLevel = SeaLevel(
        sg = p1.sg,
        time = p1.time,
    )
}
