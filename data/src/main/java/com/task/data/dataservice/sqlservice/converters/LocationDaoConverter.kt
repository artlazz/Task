package com.task.data.dataservice.sqlservice.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.task.data.dataservice.sqlservice.model.LocationDao
import org.koin.java.KoinJavaComponent.inject


class LocationDaoConverter {
    private val moshi: Moshi by inject(Moshi::class.java)
    private val jsonAdapter: JsonAdapter<LocationDao> = moshi.adapter(LocationDao::class.java)

    @TypeConverter
    fun itemToJson(value: LocationDao): String = jsonAdapter.toJson(value)

    @TypeConverter
    fun jsonToItem(value: String): LocationDao? = jsonAdapter.fromJson(value)
}