package com.task.domain.usecase.save_user

import com.task.domain.model.user.UserItem

interface SaveUserUseCase {
    suspend operator fun invoke(userItem: UserItem)
}