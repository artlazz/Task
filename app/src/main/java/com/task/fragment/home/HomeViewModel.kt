package com.task.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.task.base.BaseViewModel
import com.task.base.statemodel.LoadingStateModel.LoadingInvisibleModel
import com.task.base.statemodel.LoadingStateModel.LoadingVisibleModel
import com.task.domain.usecase.get_albums_with_photos.GetAlbumsWithPhotosUseCase
import com.task.fragment.home.datastate.HomeDataState
import com.task.fragment.home.datastate.HomeDataState.AlbumsList
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAlbumsWithPhotosUseCase: GetAlbumsWithPhotosUseCase
) : BaseViewModel() {
    private val _homeDataState = MutableLiveData<HomeDataState>()
    val homeDataState: LiveData<HomeDataState> = _homeDataState

    init {
        _loading.value = LoadingVisibleModel
        viewModelScope.launch {
            _homeDataState.value = AlbumsList(getAlbumsWithPhotosUseCase())
        }.invokeOnCompletion { _loading.value = LoadingInvisibleModel }
    }
}