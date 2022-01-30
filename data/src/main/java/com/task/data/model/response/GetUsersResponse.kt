package com.task.data.model.response

import com.task.data.model.paging.PageInfo
import com.task.data.model.user.UserItemDto

data class GetUsersResponse(
    val results: List<UserItemDto?>? = null,
    val info: PageInfo? = null
)