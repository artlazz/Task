package com.task.data.dataservice.sqlservice.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.task.data.dataservice.sqlservice.model.StreetDao
import org.koin.java.KoinJavaComponent.inject


class StreetDaoConverter {
    private val moshi: Moshi by inject(Moshi::class.java)
    private val jsonAdapter: JsonAdapter<StreetDao> = moshi.adapter(StreetDao::class.java)

    @TypeConverter
    fun itemToJson(value: StreetDao): String = jsonAdapter.toJson(value)

    @TypeConverter
    fun jsonToItem(value: String): StreetDao? = jsonAdapter.fromJson(value)
}