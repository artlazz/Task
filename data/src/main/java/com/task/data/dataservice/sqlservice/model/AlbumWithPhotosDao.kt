package com.task.data.dataservice.sqlservice.model

import androidx.room.Embedded
import androidx.room.Relation

data class AlbumWithPhotosDao(
    @Embedded val albumItemDao: AlbumItemDao,
    @Relation(
        parentColumn = "id",
        entityColumn = "albumId"
    ) val photos: List<PhotoItemDao>
)
