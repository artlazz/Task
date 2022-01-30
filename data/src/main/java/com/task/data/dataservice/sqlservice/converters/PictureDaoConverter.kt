package com.task.data.dataservice.sqlservice.converters

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.task.data.dataservice.sqlservice.model.PictureDao
import org.koin.java.KoinJavaComponent.inject


class PictureDaoConverter {
    private val moshi: Moshi by inject(Moshi::class.java)
    private val jsonAdapter: JsonAdapter<PictureDao> = moshi.adapter(PictureDao::class.java)

    @TypeConverter
    fun itemToJson(value: PictureDao): String = jsonAdapter.toJson(value)

    @TypeConverter
    fun jsonToItem(value: String): PictureDao? = jsonAdapter.fromJson(value)
}