package com.task.fragment.stations

import androidx.lifecycle.viewModelScope
import com.task.base.BaseViewModel
import com.task.common.model.stations.Stations
import com.task.domain.usecase.stations.StationsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StationsViewModel(
    private val stationsUseCase: StationsUseCase
) : BaseViewModel() {

    private val _stationData = MutableStateFlow<List<Stations>>(emptyList())
    val stationsData = _stationData.asStateFlow()

    init {
        fetchStations()
    }

    private fun fetchStations() {
        viewModelScope.launch {
            stationsUseCase.fetchStations()
                .onStart {
                    //do loading
                }
                .onEach {
                    println("onEach")
                    _stationData.value = it
                }
                .collect()
        }
    }
}