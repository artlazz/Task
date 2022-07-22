package com.task.fragment.details

import androidx.lifecycle.viewModelScope
import com.task.base.BaseViewModel
import com.task.domain.usecase.whether.extremes.ExtremesUseCase
import com.task.domain.usecase.whether.sealevel.SeaLevelUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(private val extremesUseCase: ExtremesUseCase,private val seaLevelUseCase: SeaLevelUseCase) : BaseViewModel() {

    fun getExtremes(lat: Double, lng: Double){
        viewModelScope.launch {
            extremesUseCase.invoke(lat,lng)
        }
    }
    fun getSeaLevels(lat: Double, lng: Double){
        viewModelScope.launch {
            seaLevelUseCase.invoke(lat,lng)
        }
    }
}