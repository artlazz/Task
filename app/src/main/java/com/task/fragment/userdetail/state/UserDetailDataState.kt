package com.task.fragment.userdetail.state

import com.task.domain.model.user.UserItem

sealed class UserDetailDataState {
    class UserInfo(val userItem: UserItem, val isSaved: Boolean) : UserDetailDataState()
}
