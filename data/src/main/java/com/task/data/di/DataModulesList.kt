package com.task.data.di

import com.task.data.executor.serviceExecutorModule
import com.task.data.http.httpModule
import com.task.data.repositories.auth.authRepositoryModule
import com.task.data.repositories.stations.stationsRepositoryModule

val dataModulesList = listOf(
    httpModule,
    serviceExecutorModule,
    mappersModule,
    authRepositoryModule,
    providersModule,
    stationsRepositoryModule
)
