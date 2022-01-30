package com.task.domain.mappers.ui_to_dao_mappers

import com.task.data.dataservice.sqlservice.model.StreetDao
import com.task.domain.model.Street

internal class StreetUiToDaoMapper : (Street) -> StreetDao {
    override fun invoke(itemDto: Street) = StreetDao(
        number = itemDto.number,
        name = itemDto.name
    )
}