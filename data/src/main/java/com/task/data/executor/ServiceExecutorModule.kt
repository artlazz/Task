package com.task.data.executor

import org.koin.dsl.module

internal val serviceExecutorModule = module {
    single {
        ServiceExecutor(
            get()
        )
    }
}