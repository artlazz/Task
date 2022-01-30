package com.task.domain.usecase.remove_saved_user

import com.task.domain.mappers.qualifierUserItemUiToDaoMapper
import org.koin.dsl.module

internal val removeSavedUserUseCaseModule = module {
    factory<RemoveSavedUserUseCase> {
        RemoveSavedUserUseCaseImpl(
            usersRepository = get(),
            userItemUiToDaoMapper = get(qualifierUserItemUiToDaoMapper)
        )
    }
}