package com.task.data.executor

import com.task.data.di.toErrorResponseMapperQualifier
import org.koin.dsl.module

internal val serviceExecutorModule = module {
    single { ServiceExecutor(get(toErrorResponseMapperQualifier)) }
}