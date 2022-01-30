package com.task.domain.usecase.users_next

import com.task.domain.model.user.UserItem

interface GetUsersNextListUseCase {
    suspend operator fun invoke(oldList: List<UserItem>): List<UserItem>
}