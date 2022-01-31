package com.task.domain.mappers.dao_to_ui

import com.task.data.dataservice.sqlservice.model.AlbumItemDao
import com.task.data.dataservice.sqlservice.model.AlbumWithPhotosDao
import com.task.data.dataservice.sqlservice.model.PhotoItemDao
import com.task.domain.model.AlbumItem
import com.task.domain.model.AlbumWithPhotos
import com.task.domain.model.PhotoItem

internal class AlbumWithPhotosDaoToUiMapper(
    private val albumItemDaoToUiMapper: (AlbumItemDao) -> AlbumItem,
    private val photoItemDaoToUiMapper: (PhotoItemDao) -> PhotoItem
) : (AlbumWithPhotosDao) -> AlbumWithPhotos {
    override fun invoke(item: AlbumWithPhotosDao) = AlbumWithPhotos(
        album = albumItemDaoToUiMapper(item.albumItemDao),
        photos = item.photos.map { photoItemDaoToUiMapper(it) }
    )
}