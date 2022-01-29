package com.task.domain.di

import com.task.data.di.dataModulesList
import org.koin.dsl.module

val domainModulesList = listOf(
    module { }
) + dataModulesList