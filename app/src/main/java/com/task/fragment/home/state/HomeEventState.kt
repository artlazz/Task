package com.task.fragment.home.state

import com.task.domain.model.user.UserItem

sealed class HomeEventState {
    class NavigateToUserDetail(val userItem: UserItem) : HomeEventState()
}
