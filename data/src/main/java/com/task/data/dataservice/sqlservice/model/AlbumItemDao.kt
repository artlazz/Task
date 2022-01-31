package com.task.data.dataservice.sqlservice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class AlbumItemDao(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val title: String,
    val userId: Int
)
