package com.task.data.dataservice.sqlservice

import androidx.room.*

@Dao
internal interface BaseDAO<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg item: T)

    @Delete
    suspend fun delete(vararg item: T?)

    @Update
    suspend fun update(vararg item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<T>)
}