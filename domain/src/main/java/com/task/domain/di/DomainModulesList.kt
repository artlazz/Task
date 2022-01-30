package com.task.domain.di

import com.task.data.di.dataModulesList
import com.task.domain.mappers.mappersModule
import com.task.domain.usecase.check_user.checkIsSavedUserUseCaseModule
import com.task.domain.usecase.remove_saved_user.removeSavedUserUseCaseModule
import com.task.domain.usecase.save_user.saveUserUseCaseModule
import com.task.domain.usecase.saved_users.getSavedUsersListUseCaseModule
import com.task.domain.usecase.seached_users.getSearchedUsersListUseCaseModule
import com.task.domain.usecase.users.getUsersListUseCaseModule
import com.task.domain.usecase.users_next.getUsersNextListUseCaseModule

val domainModulesList = listOf(
    mappersModule,
    getUsersListUseCaseModule,
    getSearchedUsersListUseCaseModule,
    getSavedUsersListUseCaseModule,
    saveUserUseCaseModule,
    removeSavedUserUseCaseModule,
    getUsersNextListUseCaseModule,
    checkIsSavedUserUseCaseModule
) + dataModulesList