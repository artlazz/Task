package com.task.data.dataservice.sqlservice.dao

import androidx.room.Dao
import com.task.data.dataservice.sqlservice.BaseDao
import com.task.data.dataservice.sqlservice.model.PhotoItemDao

@Dao
internal interface PhotosDao : BaseDao<PhotoItemDao>