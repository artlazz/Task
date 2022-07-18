package com.task.di

import com.task.domain.usecase.login.LoginUseCase
import com.task.domain.usecase.login.LoginUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<LoginUseCase> {
        LoginUseCaseImpl(
            get()
        )
    }
}
