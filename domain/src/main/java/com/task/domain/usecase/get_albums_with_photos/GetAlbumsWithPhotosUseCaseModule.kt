package com.task.domain.usecase.get_albums_with_photos

import com.task.domain.mappers.qualifierAlbumWithPhotosDaoToUiMapper
import org.koin.dsl.module

internal val getAlbumsWithPhotosUseCaseModule = module {
    factory<GetAlbumsWithPhotosUseCase> {
        GetAlbumsWithPhotosUseCaseImpl(
            albumsRepository = get(),
            albumWithPhotosDaoToUiMapper = get(qualifierAlbumWithPhotosDaoToUiMapper)
        )
    }
}