package com.task.data.dataservice.sqlservice

import androidx.room.Database
import androidx.room.RoomDatabase
import com.task.data.BuildConfig.DATABASE_VERSION
import com.task.data.dataservice.sqlservice.dao.AlbumsDao
import com.task.data.dataservice.sqlservice.dao.PhotosDao
import com.task.data.dataservice.sqlservice.model.AlbumItemDao
import com.task.data.dataservice.sqlservice.model.PhotoItemDao

@Database(
    entities = [AlbumItemDao::class, PhotoItemDao::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
internal abstract class AppDataBase : RoomDatabase() {
    abstract fun albumsDao(): AlbumsDao
    abstract fun photosDao(): PhotosDao
}