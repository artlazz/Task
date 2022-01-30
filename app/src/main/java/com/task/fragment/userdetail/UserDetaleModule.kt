package com.task.fragment.userdetail

import com.task.domain.model.user.UserItem
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val userDetailModule = module {
    viewModel { (userItem: UserItem) ->
        UserDetailViewModel(
            userItem = userItem,
            saveUserUseCase = get(),
            removeSavedUserUseCase = get(),
            checkIsSavedUserUseCase = get()
        )
    }
}