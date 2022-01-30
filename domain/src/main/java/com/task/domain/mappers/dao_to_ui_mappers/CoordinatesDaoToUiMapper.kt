package com.task.domain.mappers.dao_to_ui_mappers

import com.task.data.dataservice.sqlservice.model.CoordinatesDao
import com.task.domain.model.Coordinates

internal class CoordinatesDaoToUiMapper : (CoordinatesDao) -> Coordinates {
    override fun invoke(itemDao: CoordinatesDao) = Coordinates(
        latitude = itemDao.latitude,
        longitude = itemDao.longitude
    )
}