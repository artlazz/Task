package com.task.data.dataservice.sqlservice.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.task.data.dataservice.sqlservice.BaseDao
import com.task.data.dataservice.sqlservice.model.AlbumItemDao
import com.task.data.dataservice.sqlservice.model.AlbumWithPhotosDao

@Dao
internal interface AlbumsDao : BaseDao<AlbumItemDao> {
    @Transaction
    @Query("SELECT * FROM albums")
    suspend fun getAlbumsWithPhotos(): List<AlbumWithPhotosDao>
}