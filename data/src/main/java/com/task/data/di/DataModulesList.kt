package com.task.data.di

import com.task.data.dataservice.sqlservice.dataBaseModule
import com.task.data.executor.serviceExecutorModule
import com.task.data.http.httpModule
import com.task.data.mappers.mappersModule
import com.task.data.repository.albums.albumsRepositoryModule

val dataModulesList = listOf(
    httpModule,
    dataBaseModule,
    serviceExecutorModule,
    mappersModule,
    albumsRepositoryModule
)