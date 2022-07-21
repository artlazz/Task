package com.task.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.task.base.BaseViewModel
import com.task.common.model.station.Station
import com.task.domain.usecase.whether.stations.StationsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val stationsUseCase: StationsUseCase) : BaseViewModel() {
    private var _stationLiveDat = MutableLiveData<List<Station?>?>()
    val stationLiveDat: LiveData<List<Station?>?>
        get() = _stationLiveDat

    fun getFakeStations(){
        val fake = mutableListOf(Station(40.0, 40.0, "name", "source"),Station(40.0, 40.0, "name", "source"),Station(40.0, 40.0, "name", "source"),Station(40.0, 40.0, "name", "source"),Station(40.0, 40.0, "name", "source"))
        _stationLiveDat.value = fake
    }

    fun getStations(lat: Double, lng: Double) {
        viewModelScope.launch {
            stationsUseCase.invoke(1000.0, lat, lng).collect {
                _stationLiveDat.value = it
            }
        }
    }
}