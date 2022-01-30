package com.task.data.repository.users

import org.koin.dsl.module

internal val usersRepositoryModule = module {
    factory<UsersRepository> {
        UsersRepositoryImpl(
            serviceExecutor = get(),
            userApiService = get(),
            usersDataBaseService = get()
        )
    }
}