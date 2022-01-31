package com.task.domain.mappers

import com.task.data.dataservice.sqlservice.model.AlbumItemDao
import com.task.data.dataservice.sqlservice.model.AlbumWithPhotosDao
import com.task.data.dataservice.sqlservice.model.PhotoItemDao
import com.task.domain.mappers.dao_to_ui.AlbumItemDaoToUiMapper
import com.task.domain.mappers.dao_to_ui.AlbumWithPhotosDaoToUiMapper
import com.task.domain.mappers.dao_to_ui.PhotoItemDaoToUiMapper
import com.task.domain.model.AlbumItem
import com.task.domain.model.AlbumWithPhotos
import com.task.domain.model.PhotoItem
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

internal val qualifierAlbumItemDaoToUiMapper = StringQualifier("qualifierAlbumItemDaoToUiMapper")
internal val qualifierPhotoItemDaoToUiMapper = StringQualifier("qualifierPhotoItemDaoToUiMapper")
internal val qualifierAlbumWithPhotosDaoToUiMapper =
    StringQualifier("qualifierAlbumWithPhotosDaoToUiMapper")

internal val mappersModule = module {
    // dao to ui mappers
    factory<(AlbumItemDao) -> AlbumItem>(qualifierAlbumItemDaoToUiMapper) { AlbumItemDaoToUiMapper() }
    factory<(PhotoItemDao) -> PhotoItem>(qualifierPhotoItemDaoToUiMapper) { PhotoItemDaoToUiMapper() }
    factory<(AlbumWithPhotosDao) -> AlbumWithPhotos>(qualifierAlbumWithPhotosDaoToUiMapper) {
        AlbumWithPhotosDaoToUiMapper(
            albumItemDaoToUiMapper = get(qualifierAlbumItemDaoToUiMapper),
            photoItemDaoToUiMapper = get(qualifierPhotoItemDaoToUiMapper)
        )
    }
}