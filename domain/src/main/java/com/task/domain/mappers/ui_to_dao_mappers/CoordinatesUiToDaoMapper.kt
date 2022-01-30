package com.task.domain.mappers.ui_to_dao_mappers

import com.task.data.dataservice.sqlservice.model.CoordinatesDao
import com.task.domain.model.Coordinates

internal class CoordinatesUiToDaoMapper : (Coordinates) -> CoordinatesDao {
    override fun invoke(itemDto: Coordinates) = CoordinatesDao(
        latitude = itemDto.latitude,
        longitude = itemDto.longitude
    )
}