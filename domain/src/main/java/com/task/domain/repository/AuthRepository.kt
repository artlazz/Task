package com.task.domain.repository

import com.task.common.model.user.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(
        username: String,
        password: String
    ): Flow<User>
}
