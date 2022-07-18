package com.task.data.repositories.auth

import com.task.data.di.loginRequestProviderQualifier
import com.task.data.di.toUserMapperQualifier
import com.task.domain.repository.AuthRepository
import org.koin.dsl.module

val authRepositoryModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(
            serviceExecutor = get(),
            userApiService = get(),
            loginRequestProvider = get(loginRequestProviderQualifier),
            toUserModelMapper = get(toUserMapperQualifier)
        )
    }
}