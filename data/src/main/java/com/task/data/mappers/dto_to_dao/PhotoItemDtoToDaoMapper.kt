package com.task.data.mappers.dto_to_dao

import com.task.common.util.DUMMY
import com.task.common.util.EMPTY
import com.task.data.dataservice.apiservice.model.PhotoItemDto
import com.task.data.dataservice.sqlservice.model.PhotoItemDao

internal class PhotoItemDtoToDaoMapper : (PhotoItemDto) -> PhotoItemDao {
    override fun invoke(item: PhotoItemDto) = PhotoItemDao(
        albumId = item.albumId ?: Int.DUMMY,
        id = item.id ?: Int.DUMMY,
        title = item.title ?: String.EMPTY,
        url = item.url ?: String.EMPTY,
        thumbnailUrl = item.thumbnailUrl ?: String.EMPTY
    )
}