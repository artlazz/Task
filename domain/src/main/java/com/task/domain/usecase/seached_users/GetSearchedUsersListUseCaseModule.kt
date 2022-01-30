package com.task.domain.usecase.seached_users

import org.koin.dsl.module

internal val getSearchedUsersListUseCaseModule = module {
    factory<GetSearchedUsersListUseCase> { GetSearchedUsersListUseCaseImpl() }
}