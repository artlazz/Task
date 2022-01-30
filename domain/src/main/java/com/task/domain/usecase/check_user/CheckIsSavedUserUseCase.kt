package com.task.domain.usecase.check_user

interface CheckIsSavedUserUseCase {
    suspend operator fun invoke(userId: String): Boolean
}