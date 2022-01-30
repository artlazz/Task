package com.task.data.dataservice.sqlservice

import androidx.room.Room
import com.task.data.BuildConfig.DATABASE_NAME
import com.task.data.dataservice.sqlservice.users.UsersDataBaseService
import com.task.data.dataservice.sqlservice.users.UsersDataBaseServiceImpl
import org.koin.dsl.module

internal val dataBaseModule = module {
    single { Room.databaseBuilder(get(), AppDataBase::class.java, DATABASE_NAME).build() }
    single { get<AppDataBase>().usersDao() }
    factory<UsersDataBaseService> { UsersDataBaseServiceImpl(get()) }
}