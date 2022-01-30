package com.task.domain.mappers.dao_to_ui_mappers

import com.task.data.dataservice.sqlservice.model.PictureDao
import com.task.domain.model.Picture

internal class PictureDaoToUiMapper : (PictureDao) -> Picture {
    override fun invoke(itemDao: PictureDao) = Picture(
        thumbnail = itemDao.thumbnail,
        large = itemDao.large,
        medium = itemDao.medium
    )
}