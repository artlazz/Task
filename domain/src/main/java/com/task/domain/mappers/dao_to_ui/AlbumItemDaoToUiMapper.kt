package com.task.domain.mappers.dao_to_ui

import com.task.data.dataservice.sqlservice.model.AlbumItemDao
import com.task.domain.model.AlbumItem

internal class AlbumItemDaoToUiMapper : (AlbumItemDao) -> AlbumItem {
    override fun invoke(item: AlbumItemDao) = AlbumItem(
        id = item.id,
        title = item.title,
        userId = item.userId
    )
}