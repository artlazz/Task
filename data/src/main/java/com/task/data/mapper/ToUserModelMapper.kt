package com.task.data.mapper

import com.task.common.model.user.User
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.response.UserResponse

class ToUserModelMapper : BaseMapper<UserResponse, User> {
    override fun invoke(response: UserResponse) = User(
        name = response.name
    )
}