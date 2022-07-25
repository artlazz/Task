package com.task.fragment.stations

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val stationsModule = module {
    viewModel { StationsViewModel(get()) }
}