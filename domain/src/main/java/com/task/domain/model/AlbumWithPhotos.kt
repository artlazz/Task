package com.task.domain.model

data class AlbumWithPhotos(
    val album: AlbumItem,
    val photos: List<PhotoItem>
)
