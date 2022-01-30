package com.task.domain.mappers.ui_to_dao_mappers

import com.task.data.dataservice.sqlservice.model.TimezoneDao
import com.task.domain.model.Timezone

internal class TimezoneUiToDaoMapper : (Timezone) -> TimezoneDao {
    override fun invoke(itemDto: Timezone) = TimezoneDao(
        offset = itemDto.offset,
        description = itemDto.description
    )
}