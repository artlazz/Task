package com.task.domain.usecase.get_albums_with_photos

import com.task.data.dataservice.sqlservice.model.AlbumWithPhotosDao
import com.task.data.repository.albums.AlbumsRepository
import com.task.domain.model.AlbumWithPhotos

internal class GetAlbumsWithPhotosUseCaseImpl(
    private val albumsRepository: AlbumsRepository,
    private val albumWithPhotosDaoToUiMapper: (AlbumWithPhotosDao) -> AlbumWithPhotos
) : GetAlbumsWithPhotosUseCase {
    override suspend fun invoke(): List<AlbumWithPhotos> =
        albumsRepository.getAlbumsWithPhotos()
            .map { albumWithPhotosDaoToUiMapper(it) }
}