package com.task.data.repository.albums

import com.task.data.dataservice.apiservice.model.AlbumItemDto
import com.task.data.dataservice.apiservice.model.PhotoItemDto
import com.task.data.dataservice.sqlservice.model.AlbumWithPhotosDao

interface AlbumsRepository {
    suspend fun getAlbums(): List<AlbumItemDto>

    suspend fun getPhotos(albumId: Int): List<PhotoItemDto>

    suspend fun getAlbumsWithPhotos(): List<AlbumWithPhotosDao>
}