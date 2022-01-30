package com.task.domain.usecase.check_user

import com.task.data.repository.users.UsersRepository

internal class CheckIsSavedUserUseCaseImpl(
    private val usersRepository: UsersRepository
) : CheckIsSavedUserUseCase {
    override suspend fun invoke(userId: String): Boolean =
        usersRepository.getSavedUser(userId) != null
}