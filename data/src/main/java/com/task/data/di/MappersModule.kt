package com.task.data.di

import com.task.common.model.error.ErrorResponse
import com.task.common.model.extrems.Extremes
import com.task.common.model.sealevel.SeaLevel
import com.task.common.model.station.Station
import com.task.data.mapper.ToExtremesModelMapper
import com.task.data.mapper.ToSeaLevelModelMapper
import com.task.data.mapper.ToStationModelMapper
import com.task.data.mapper.base.BaseMapper
import com.task.data.mapper.error.RequestExceptionToBaseErrorMapper
import com.task.data.model.response.Data
import com.task.data.model.response.ExtremesData
import com.task.data.model.response.SeaLevelData
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

internal val toErrorResponseMapperQualifier = StringQualifier("toErrorResponseMapperQualifier")
internal val toUserMapperQualifier = StringQualifier("toUserMapperQualifier")
internal val toStationMapperQualifier = StringQualifier("toStationMapperQualifier")
internal val toExtremesModelMapper = StringQualifier("toExtremesModelMapper")
internal val toSeaLevelModelMapper = StringQualifier("toExtremesModelMapper")

internal val mappersModule = module {
    single<BaseMapper<Throwable, ErrorResponse>>(toErrorResponseMapperQualifier) {
        RequestExceptionToBaseErrorMapper()
    }
    single<BaseMapper<Data, Station>>(toStationMapperQualifier) {
        ToStationModelMapper()
    }
    single<BaseMapper<ExtremesData, Extremes>>(toExtremesModelMapper) {
        ToExtremesModelMapper()
    }
    single<BaseMapper<SeaLevelData, SeaLevel>>(toSeaLevelModelMapper) {
        ToSeaLevelModelMapper()
    }
}