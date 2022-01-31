package com.task.data.dataservice.sqlservice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoItemDao(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
