package com.task.di

import com.task.domain.usecase.whether.extremes.ExtremesUseCase
import com.task.domain.usecase.whether.extremes.ExtremesUseCaseImpl
import com.task.domain.usecase.whether.sealevel.SeaLevelUseCase
import com.task.domain.usecase.whether.sealevel.SeaLevelUseCaseImpl
import com.task.domain.usecase.whether.stations.StationsUseCase
import com.task.domain.usecase.whether.stations.StationsUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
//    single<LoginUseCase> {
//        LoginUseCaseImpl(
//            get()
//        )
//    }
    single<StationsUseCase> {
        StationsUseCaseImpl(get())
    }
    single<ExtremesUseCase> {
        ExtremesUseCaseImpl(get())
    }
    single<SeaLevelUseCase> {
        SeaLevelUseCaseImpl(get())
    }
}
