package com.task.domain.mappers.dao_to_ui

import com.task.data.dataservice.sqlservice.model.PhotoItemDao
import com.task.domain.model.PhotoItem

internal class PhotoItemDaoToUiMapper : (PhotoItemDao) -> PhotoItem {
    override fun invoke(item: PhotoItemDao) = PhotoItem(
        albumId = item.albumId,
        id = item.id,
        title = item.title,
        url = item.url,
        thumbnailUrl = item.thumbnailUrl
    )
}