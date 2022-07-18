package com.task.domain.usecase.login

import com.task.common.model.user.User
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    suspend operator fun invoke(email: String, password: String): Flow<User>
}
