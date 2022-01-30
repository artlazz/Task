package com.task.data.repository.users

import com.task.data.dataservice.apiservice.UserApiService
import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.data.dataservice.sqlservice.users.UsersDataBaseService
import com.task.data.executor.ServiceExecutor
import com.task.data.model.user.UserItemDto

internal class UsersRepositoryImpl(
    private val serviceExecutor: ServiceExecutor,
    private val userApiService: UserApiService,
    private val usersDataBaseService: UsersDataBaseService
) : UsersRepository {
    override suspend fun getUsersList(page: Int, pageSize: Int): List<UserItemDto?>? =
        serviceExecutor.execute {
            return@execute userApiService.getUsersList(results = pageSize, page = page).results
        }

    override suspend fun getSavedUsersList(): List<UserItemDao?> =
        usersDataBaseService.getAllSavedUsers()

    override suspend fun saveUser(userItemDto: UserItemDao) {
        usersDataBaseService.saveUser(userItemDto)
    }

    override suspend fun getSavedUser(userId: String): UserItemDao? =
        usersDataBaseService.getUser(userId)

    override suspend fun removeSavedUser(userItemDto: UserItemDao) {
        usersDataBaseService.removeUser(userItemDto)
    }
}