package com.task.data.dataservice.sqlservice.users

import androidx.room.Dao
import androidx.room.Query
import com.task.data.dataservice.sqlservice.BaseDAO
import com.task.data.dataservice.sqlservice.model.user.UserItemDao

@Dao
internal interface UsersDao : BaseDAO<UserItemDao> {
    @Query("SELECT * FROM useritemdao WHERE id = :userId")
    suspend fun getUser(userId: String): UserItemDao

    @Query("SELECT * FROM useritemdao")
    suspend fun getUsers(): List<UserItemDao>
}