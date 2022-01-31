package com.task.fragment.home.datastate

import com.task.domain.model.AlbumWithPhotos

sealed class HomeDataState {
    class AlbumsList(val list: List<AlbumWithPhotos>) : HomeDataState()
}
