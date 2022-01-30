package com.task.fragment.home.state

import com.task.domain.model.user.UserItem

sealed class HomeDataState {
    class UsersListData(val data: List<UserItem>) : HomeDataState()
    object EmptyData : HomeDataState()
}
