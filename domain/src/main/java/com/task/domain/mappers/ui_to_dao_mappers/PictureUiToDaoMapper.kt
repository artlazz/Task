package com.task.domain.mappers.ui_to_dao_mappers

import com.task.data.dataservice.sqlservice.model.PictureDao
import com.task.domain.model.Picture

internal class PictureUiToDaoMapper : (Picture) -> PictureDao {
    override fun invoke(item: Picture) = PictureDao(
        thumbnail = item.thumbnail,
        large = item.large,
        medium = item.medium
    )
}