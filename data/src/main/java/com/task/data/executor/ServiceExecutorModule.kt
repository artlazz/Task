package com.task.data.executor

import com.task.data.AppError
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

private val qualifierErrorMapper = StringQualifier("qualifierErrorMapper")

internal val serviceExecutorModule = module {
    factory { ServiceExecutor(get(qualifierErrorMapper)) }
    factory<(Exception) -> AppError>(qualifierErrorMapper) { CallErrorMapper() }
}