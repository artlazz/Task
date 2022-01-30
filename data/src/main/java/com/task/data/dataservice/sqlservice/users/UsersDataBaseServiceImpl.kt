package com.task.data.dataservice.sqlservice.users

import com.task.data.dataservice.sqlservice.model.user.UserItemDao

internal class UsersDataBaseServiceImpl(
    private val usersDao: UsersDao
) : UsersDataBaseService {
    override suspend fun getAllSavedUsers(): List<UserItemDao> = usersDao.getUsers()

    override suspend fun saveUser(userItemDto: UserItemDao) {
        usersDao.insert(userItemDto)
    }

    override suspend fun removeUser(userItemDto: UserItemDao) {
        usersDao.delete(userItemDto)
    }

    override suspend fun getUser(userId: String) = usersDao.getUser(userId)
}