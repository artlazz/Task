package com.task.data.repositories.auth

import com.task.common.model.user.User
import com.task.data.dataservice.apiservice.UserApiService
import com.task.data.executor.ServiceExecutor
import com.task.data.mapper.base.BaseMapper
import com.task.data.model.response.UserResponse
import com.task.data.providers.LoginRequestProvider
import com.task.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

internal class AuthRepositoryImpl(
    private val serviceExecutor: ServiceExecutor,
    private val userApiService: UserApiService,
    private val loginRequestProvider: LoginRequestProvider,
    private val toUserModelMapper: BaseMapper<UserResponse, User>
) : AuthRepository {
    override suspend fun login(username: String, password: String): Flow<User> =
        serviceExecutor.execute {
            toUserModelMapper(
                userApiService.login(
                    loginRequestProvider(
                        username,
                        password
                    )
                )
            )
        }
}