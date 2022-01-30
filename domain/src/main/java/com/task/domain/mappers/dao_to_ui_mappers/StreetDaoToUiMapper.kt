package com.task.domain.mappers.dao_to_ui_mappers

import com.task.data.dataservice.sqlservice.model.StreetDao
import com.task.domain.model.Street

internal class StreetDaoToUiMapper : (StreetDao) -> Street {
    override fun invoke(itemDao: StreetDao) = Street(
        number = itemDao.number,
        name = itemDao.name
    )
}