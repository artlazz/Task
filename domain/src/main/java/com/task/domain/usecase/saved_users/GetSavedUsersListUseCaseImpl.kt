package com.task.domain.usecase.saved_users

import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.data.repository.users.UsersRepository
import com.task.domain.model.user.UserItem

internal class GetSavedUsersListUseCaseImpl(
    private val usersRepository: UsersRepository,
    private val userItemDaoToUiMapper: (UserItemDao) -> UserItem
) : GetSavedUsersListUseCase {
    override suspend fun invoke(): List<UserItem> = usersRepository.getSavedUsersList()
        ?.filterNotNull()
        ?.map { userItemDaoToUiMapper(it) }
        ?: emptyList()
}