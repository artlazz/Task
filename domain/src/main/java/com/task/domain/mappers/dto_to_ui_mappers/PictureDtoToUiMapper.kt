package com.task.domain.mappers.dto_to_ui_mappers

import com.task.common.util.EMPTY
import com.task.data.model.PictureDto
import com.task.domain.model.Picture

internal class PictureDtoToUiMapper : (PictureDto) -> Picture {
    override fun invoke(itemDto: PictureDto): Picture = Picture(
        thumbnail = itemDto.thumbnail ?: String.EMPTY,
        large = itemDto.large ?: String.EMPTY,
        medium = itemDto.medium ?: String.EMPTY
    )
}