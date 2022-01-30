package com.task.domain.usecase.seached_users

import com.task.domain.model.user.UserItem

interface GetSearchedUsersListUseCase {
    suspend operator fun invoke(searchText: String, fullList: List<UserItem>): List<UserItem>
}