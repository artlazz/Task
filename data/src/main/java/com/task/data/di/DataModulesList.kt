package com.task.data.di

import com.task.data.dataservice.sqlservice.dataBaseModule
import com.task.data.executor.serviceExecutorModule
import com.task.data.http.httpModule

val dataModulesList = listOf(
    httpModule,
    dataBaseModule,
    serviceExecutorModule
)