package com.task.domain.mappers.dto_to_ui_mappers

import com.task.common.util.EMPTY
import com.task.data.model.CoordinatesDto
import com.task.domain.model.Coordinates

internal class CoordinatesDtoToUiMapper : (CoordinatesDto) -> Coordinates {
    override fun invoke(itemDto: CoordinatesDto): Coordinates = Coordinates(
        latitude = itemDto.latitude ?: String.EMPTY,
        longitude = itemDto.longitude ?: String.EMPTY
    )
}