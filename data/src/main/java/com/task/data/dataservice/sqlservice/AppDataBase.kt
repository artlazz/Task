package com.task.data.dataservice.sqlservice

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task.data.BuildConfig.DATABASE_VERSION
import com.task.data.dataservice.sqlservice.converters.*
import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.data.dataservice.sqlservice.users.UsersDao


@Database(
    entities = [UserItemDao::class], // FIXME add UserItemDao data class model for room database only
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(
    // FIXME change converters to relationship
    TimezoneDaoConverter::class,
    StreetDaoConverter::class,
    PictureDaoConverter::class,
    LocationDaoConverter::class,
    CoordinatesDaoConverter::class
)
internal abstract class AppDataBase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}