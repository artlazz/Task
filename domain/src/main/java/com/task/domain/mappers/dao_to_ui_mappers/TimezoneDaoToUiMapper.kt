package com.task.domain.mappers.dao_to_ui_mappers

import com.task.data.dataservice.sqlservice.model.TimezoneDao
import com.task.domain.model.Timezone

internal class TimezoneDaoToUiMapper : (TimezoneDao) -> Timezone {
    override fun invoke(itemDao: TimezoneDao) = Timezone(
        offset = itemDao.offset,
        description = itemDao.description
    )
}