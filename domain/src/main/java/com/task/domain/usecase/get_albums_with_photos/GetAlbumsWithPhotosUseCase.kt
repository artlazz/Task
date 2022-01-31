package com.task.domain.usecase.get_albums_with_photos

import com.task.domain.model.AlbumWithPhotos

interface GetAlbumsWithPhotosUseCase {
    suspend operator fun invoke(): List<AlbumWithPhotos>
}