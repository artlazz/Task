package com.task.domain.mappers.dto_to_ui_mappers

import com.task.common.util.EMPTY
import com.task.data.model.StreetDto
import com.task.domain.model.Street

internal class StreetDtoToUiMapper : (StreetDto?) -> Street {
    override fun invoke(itemDto: StreetDto?): Street = Street(
        number = itemDto?.number ?: 0,
        name = itemDto?.name ?: String.EMPTY
    )
}