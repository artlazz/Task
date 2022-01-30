package com.task.domain.usecase.remove_saved_user

import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.data.repository.users.UsersRepository
import com.task.domain.model.user.UserItem

internal class RemoveSavedUserUseCaseImpl(
    private val usersRepository: UsersRepository,
    private val userItemUiToDaoMapper: (UserItem) -> UserItemDao
) : RemoveSavedUserUseCase {
    override suspend fun invoke(userItem: UserItem) {
        usersRepository.removeSavedUser(userItemUiToDaoMapper(userItem))
    }
}