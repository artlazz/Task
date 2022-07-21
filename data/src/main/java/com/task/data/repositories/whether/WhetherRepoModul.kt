package com.task.data.repositories.whether

import com.task.data.di.toStationMapperQualifier
import com.task.domain.repository.WhetherRepo
import org.koin.dsl.module

val whetherRepositoryModule = module {
    single<WhetherRepo> {
        WhetherRepoImpl(
            serviceExecutor = get(),
            whetherApiService = get(),
            toStationsModelMapper = get(toStationMapperQualifier)
        )
    }
}