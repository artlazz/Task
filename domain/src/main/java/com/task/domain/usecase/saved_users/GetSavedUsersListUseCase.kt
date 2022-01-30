package com.task.domain.usecase.saved_users

import com.task.domain.model.user.UserItem

interface GetSavedUsersListUseCase {
    suspend operator fun invoke(): List<UserItem>
}