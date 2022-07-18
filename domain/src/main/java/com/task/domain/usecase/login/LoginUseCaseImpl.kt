package com.task.domain.usecase.login

import com.task.domain.repository.AuthRepository


class LoginUseCaseImpl(
    private val authRepository: AuthRepository
) : LoginUseCase {

    override suspend fun invoke(
        email: String,
        password: String
    ) = authRepository.login(email, password)
}
