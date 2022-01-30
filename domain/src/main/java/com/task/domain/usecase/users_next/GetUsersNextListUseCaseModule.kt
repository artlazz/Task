package com.task.domain.usecase.users_next

import com.task.domain.mappers.qualifierUserItemDtoToUiMapper
import org.koin.dsl.module

internal val getUsersNextListUseCaseModule = module {
    factory<GetUsersNextListUseCase> {
        GetUsersNextListUseCaseImpl(
            usersRepository = get(),
            userItemDtoToUiMapper = get(qualifierUserItemDtoToUiMapper)
        )
    }
}