package com.task.domain.usecase.save_user

import com.task.domain.mappers.qualifierUserItemUiToDaoMapper
import org.koin.dsl.module

internal val saveUserUseCaseModule = module {
    factory<SaveUserUseCase> {
        SaveUserUseCaseImpl(
            usersRepository = get(),
            userItemUiToDaoMapper = get(qualifierUserItemUiToDaoMapper)
        )
    }
}