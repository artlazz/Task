package com.task.domain.usecase.users_next

import com.task.common.util.DEFAULT_PAGE_SIZE
import com.task.data.model.user.UserItemDto
import com.task.data.repository.users.UsersRepository
import com.task.domain.model.user.UserItem

internal class GetUsersNextListUseCaseImpl(
    private val usersRepository: UsersRepository,
    private val userItemDtoToUiMapper: (UserItemDto) -> UserItem
) : GetUsersNextListUseCase {
    override suspend fun invoke(oldList: List<UserItem>): List<UserItem> =
        usersRepository.getUsersList(
            page = oldList.size / Int.DEFAULT_PAGE_SIZE + 1,
            pageSize = Int.DEFAULT_PAGE_SIZE
        )
            ?.filterNotNull()
            ?.map { userItemDtoToUiMapper(it) }
            ?: emptyList()
}