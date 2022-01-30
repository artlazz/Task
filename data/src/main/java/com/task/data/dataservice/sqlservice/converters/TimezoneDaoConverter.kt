package com.task.data.dataservice.sqlservice.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.task.data.dataservice.sqlservice.model.TimezoneDao
import com.task.data.model.DobDto
import org.koin.java.KoinJavaComponent.inject


class TimezoneDaoConverter {
    private val moshi: Moshi by inject(Moshi::class.java)
    private val jsonAdapter: JsonAdapter<TimezoneDao> = moshi.adapter(TimezoneDao::class.java)

    @TypeConverter
    fun itemToJson(value: TimezoneDao): String = jsonAdapter.toJson(value)

    @TypeConverter
    fun jsonToItem(value: String): TimezoneDao? = jsonAdapter.fromJson(value)
}