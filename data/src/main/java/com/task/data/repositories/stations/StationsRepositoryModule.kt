package com.task.data.repositories.stations

import com.task.data.di.toStationsMapperQualifier
import com.task.domain.repository.StationsRepository
import org.koin.dsl.module

val stationsRepositoryModule = module {
    single<StationsRepository> {
        StationsRepositoryImpl(
            serviceExecutor = get(),
            stationsApiService = get(),
            toStationsModelMapper = get(toStationsMapperQualifier)
        )
    }
}