package com.task.data.mappers.dto_to_dao

import com.task.common.util.DUMMY
import com.task.common.util.EMPTY
import com.task.data.dataservice.apiservice.model.AlbumItemDto
import com.task.data.dataservice.sqlservice.model.AlbumItemDao

internal class AlbumItemDtoToDaoMapper : (AlbumItemDto) -> AlbumItemDao {
    override fun invoke(item: AlbumItemDto) = AlbumItemDao(
        id = item.id ?: Int.DUMMY,
        title = item.title ?: String.EMPTY,
        userId = item.userId ?: Int.DUMMY
    )
}