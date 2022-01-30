package com.task.domain.usecase.save_user

import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.data.repository.users.UsersRepository
import com.task.domain.model.user.UserItem

internal class SaveUserUseCaseImpl(
    private val usersRepository: UsersRepository,
    private val userItemUiToDaoMapper: (UserItem) -> UserItemDao
) : SaveUserUseCase {
    override suspend fun invoke(userItem: UserItem) =
        usersRepository.saveUser(userItemUiToDaoMapper(userItem))
}