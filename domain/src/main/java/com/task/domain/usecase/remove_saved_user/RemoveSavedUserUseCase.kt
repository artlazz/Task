package com.task.domain.usecase.remove_saved_user

import com.task.domain.model.user.UserItem

interface RemoveSavedUserUseCase {
    suspend operator fun invoke(userItem: UserItem)
}