package com.task.data.dataservice.sqlservice.users

import com.task.data.dataservice.sqlservice.model.user.UserItemDao

interface UsersDataBaseService {
    suspend fun getAllSavedUsers(): List<UserItemDao>

    suspend fun saveUser(userItemDao: UserItemDao)

    suspend fun removeUser(userItemDao: UserItemDao)

    suspend fun getUser(userId: String): UserItemDao?
}