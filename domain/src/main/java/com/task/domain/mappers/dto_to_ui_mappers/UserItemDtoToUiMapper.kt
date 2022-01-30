package com.task.domain.mappers.dto_to_ui_mappers

import com.task.common.util.EMPTY
import com.task.data.model.LocationDto
import com.task.data.model.NameDto
import com.task.data.model.PictureDto
import com.task.data.model.user.UserItemDto
import com.task.domain.model.Location
import com.task.domain.model.Picture
import com.task.domain.model.user.UserItem

internal class UserItemDtoToUiMapper(
    private val locationDtoToUiMapper: (LocationDto?) -> Location,
    private val pictureDtoToUiMapper: (PictureDto?) -> Picture,
    private val nameDtoToUiMapper: (NameDto?) -> String
) : (UserItemDto) -> UserItem {
    override fun invoke(itemDto: UserItemDto): UserItem = UserItem(
        gender = itemDto.gender ?: String.EMPTY,
        phone = itemDto.phone ?: String.EMPTY,
        name = nameDtoToUiMapper(itemDto.name),
        location = locationDtoToUiMapper(itemDto.location),
        id = itemDto.id?.value ?: String.EMPTY,
        cell = itemDto.cell ?: String.EMPTY,
        picture = pictureDtoToUiMapper(itemDto.picture),
    )
}