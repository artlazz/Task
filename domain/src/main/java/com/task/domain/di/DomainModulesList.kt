package com.task.domain.di

import com.task.data.di.dataModulesList
import com.task.domain.mappers.mappersModule

val domainModulesList = listOf(
    mappersModule
) + dataModulesList