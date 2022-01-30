package com.task.domain.mappers.dto_to_ui_mappers

import com.task.common.util.EMPTY
import com.task.data.model.TimezoneDto
import com.task.domain.model.Timezone

internal class TimezoneDtoToUiMapper : (TimezoneDto) -> Timezone {
    override fun invoke(itemDto: TimezoneDto): Timezone = Timezone(
        offset = itemDto.offset ?: String.EMPTY,
        description = itemDto.description ?: String.EMPTY
    )
}