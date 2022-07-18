package com.task.data.di

import com.task.data.model.request.LoginRequest
import com.task.data.providers.LoginRequestProvider
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

internal val loginRequestProviderQualifier = StringQualifier("loginRequestProviderQualifier")

internal val providersModule = module {
    single<(String, String) -> LoginRequest>(loginRequestProviderQualifier) {
        LoginRequestProvider()
    }
}