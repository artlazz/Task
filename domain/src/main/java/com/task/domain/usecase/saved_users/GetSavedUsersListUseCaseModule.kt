package com.task.domain.usecase.saved_users

import com.task.domain.mappers.qualifierUserItemDaoToUiMapper
import org.koin.dsl.module

internal val getSavedUsersListUseCaseModule = module {
    factory<GetSavedUsersListUseCase> {
        GetSavedUsersListUseCaseImpl(
            usersRepository = get(),
            userItemDaoToUiMapper = get(qualifierUserItemDaoToUiMapper)
        )
    }
}