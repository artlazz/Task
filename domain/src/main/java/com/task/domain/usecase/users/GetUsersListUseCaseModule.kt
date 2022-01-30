package com.task.domain.usecase.users

import com.task.domain.mappers.qualifierUserItemDtoToUiMapper
import org.koin.dsl.module

internal val getUsersListUseCaseModule = module {
    factory<GetUsersListUseCase> {
        GetUsersListUseCaseImpl(
            usersRepository = get(),
            userItemDtoToUiMapper = get(qualifierUserItemDtoToUiMapper)
        )
    }
}