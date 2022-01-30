package com.task.domain.usecase.check_user

import org.koin.dsl.module

internal val checkIsSavedUserUseCaseModule = module {
    factory<CheckIsSavedUserUseCase> {
        CheckIsSavedUserUseCaseImpl(
            usersRepository = get()
        )
    }
}