package com.task.domain.mappers.dto_to_ui_mappers

import com.task.common.util.EMPTY
import com.task.data.model.NameDto

internal class NameDtoToUiMapper : (NameDto?) -> String {
    override fun invoke(itemDto: NameDto?): String =
        "${itemDto?.first ?: String.EMPTY} ${itemDto?.last ?: String.EMPTY}"
}