package com.task.domain.usecase.users

import com.task.domain.model.user.UserItem

interface GetUsersListUseCase {
    suspend operator fun invoke(): List<UserItem>
}