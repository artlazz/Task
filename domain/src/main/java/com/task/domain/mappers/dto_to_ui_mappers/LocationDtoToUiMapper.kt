package com.task.domain.mappers.dto_to_ui_mappers

import com.task.common.util.EMPTY
import com.task.data.model.CoordinatesDto
import com.task.data.model.LocationDto
import com.task.data.model.StreetDto
import com.task.data.model.TimezoneDto
import com.task.domain.model.Coordinates
import com.task.domain.model.Location
import com.task.domain.model.Street
import com.task.domain.model.Timezone

internal class LocationDtoToUiMapper(
    private val streetDtoToUiMapper: (StreetDto?) -> Street,
    private val timezoneDtoToUiMapper: (TimezoneDto?) -> Timezone,
    private val coordinatesDtoToUiMapper: (CoordinatesDto?) -> Coordinates
) : (LocationDto) -> Location {
    override fun invoke(itemDto: LocationDto): Location = Location(
        country = itemDto.country ?: String.EMPTY,
        city = itemDto.city ?: String.EMPTY,
        street = streetDtoToUiMapper(itemDto.street),
        timezone = timezoneDtoToUiMapper(itemDto.timezone),
        postcode = itemDto.postcode ?: String.EMPTY,
        coordinates = coordinatesDtoToUiMapper(itemDto.coordinates),
        state = itemDto.state ?: String.EMPTY
    )
}