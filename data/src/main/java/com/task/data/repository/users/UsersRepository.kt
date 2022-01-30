package com.task.data.repository.users

import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.data.model.user.UserItemDto

interface UsersRepository {
    suspend fun getUsersList(page: Int, pageSize: Int): List<UserItemDto?>?

    suspend fun getSavedUsersList(): List<UserItemDao?>?

    suspend fun saveUser(userItemDto: UserItemDao)

    suspend fun getSavedUser(userId: String): UserItemDao?

    suspend fun removeSavedUser(userItemDto: UserItemDao)
}