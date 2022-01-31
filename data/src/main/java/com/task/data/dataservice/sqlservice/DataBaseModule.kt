package com.task.data.dataservice.sqlservice

import androidx.room.Room
import com.task.data.BuildConfig.DATABASE_NAME
import org.koin.dsl.module

internal val dataBaseModule = module {
    single { Room.databaseBuilder(get(), AppDataBase::class.java, DATABASE_NAME).build() }
    single { get<AppDataBase>().albumsDao() }
    single { get<AppDataBase>().photosDao() }
}