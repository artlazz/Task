package com.task.data.repository.albums

import com.task.data.mappers.qualifierAlbumItemDtoToDaoMapper
import com.task.data.mappers.qualifierPhotoItemDtoToDaoMapper
import org.koin.dsl.module

internal val albumsRepositoryModule = module {
    factory<AlbumsRepository> {
        AlbumsRepositoryImpl(
            context = get(),
            serviceExecutor = get(),
            albumApiService = get(),
            albumsDao = get(),
            photosDao = get(),
            albumItemDtoToDaoMapper = get(qualifierAlbumItemDtoToDaoMapper),
            photoItemDtoToDaoMapper = get(qualifierPhotoItemDtoToDaoMapper)
        )
    }
}