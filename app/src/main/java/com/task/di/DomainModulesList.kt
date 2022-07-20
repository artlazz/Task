package com.task.di

import com.task.domain.usecase.login.LoginUseCase
import com.task.domain.usecase.login.LoginUseCaseImpl
import com.task.domain.usecase.stations.StationsUseCase
import com.task.domain.usecase.stations.StationsUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<LoginUseCase> {
        LoginUseCaseImpl(
            get()
        )
    }
    single<StationsUseCase> {
        StationsUseCaseImpl(

        )
    }
}
