package com.task.data.dataservice.sqlservice.converters

import com.squareup.moshi.Moshi
import org.koin.java.KoinJavaComponent.inject

//class UserDaoConverter {
//    private val moshi: Moshi by inject(Moshi::class.java)
//    private val jsonAdapter: JsonAdapter<UserDao> = moshi.adapter(UserDao::class.java)
//
//    @TypeConverter
//    fun itemToJson(value: UserDao): String = jsonAdapter.toJson(value)
//
//    @TypeConverter
//    fun jsonToItem(value: String): UserDao? = jsonAdapter.fromJson(value)
//}