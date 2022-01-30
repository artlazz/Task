package com.task.domain.usecase.users

import com.task.data.model.user.UserItemDto
import com.task.data.repository.users.UsersRepository
import com.task.domain.model.user.UserItem

internal class GetUsersListUseCaseImpl(
    private val usersRepository: UsersRepository,
    private val userItemDtoToUiMapper: (UserItemDto) -> UserItem
) : GetUsersListUseCase {

    override suspend fun invoke(): List<UserItem> =
        usersRepository.getUsersList(1, 20)
            ?.filterNotNull()
            ?.map { userItemDtoToUiMapper(it) }
            ?: emptyList()
}