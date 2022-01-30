package com.task.data.di

import com.task.data.dataservice.sqlservice.dataBaseModule
import com.task.data.executor.serviceExecutorModule
import com.task.data.http.httpModule
import com.task.data.repository.users.usersRepositoryModule

val dataModulesList = listOf(
    httpModule,
    serviceExecutorModule,
    dataBaseModule,
    usersRepositoryModule
)