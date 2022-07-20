package com.task.data.repositories.stations

import com.task.domain.repository.StationsRepository
import org.koin.dsl.module

val stationsRepositoryModule = module {
    single<StationsRepository> {
        StationsRepositoryImpl(get(), get(), get())
    }
}