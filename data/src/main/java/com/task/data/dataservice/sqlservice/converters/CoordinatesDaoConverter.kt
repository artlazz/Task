package com.task.data.dataservice.sqlservice.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.task.data.dataservice.sqlservice.model.CoordinatesDao
import org.koin.java.KoinJavaComponent.inject


class CoordinatesDaoConverter {
    private val moshi: Moshi by inject(Moshi::class.java)
    private val jsonAdapter: JsonAdapter<CoordinatesDao> = moshi.adapter(CoordinatesDao::class.java)

    @TypeConverter
    fun itemToJson(value: CoordinatesDao): String = jsonAdapter.toJson(value)

    @TypeConverter
    fun jsonToItem(value: String): CoordinatesDao? = jsonAdapter.fromJson(value)
}