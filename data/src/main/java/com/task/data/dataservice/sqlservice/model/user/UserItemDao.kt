package com.task.data.dataservice.sqlservice.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.task.data.dataservice.sqlservice.model.LocationDao
import com.task.data.dataservice.sqlservice.model.PictureDao
import java.io.Serializable

@Entity
data class UserItemDao(
    @PrimaryKey(autoGenerate = false) val id: String,
    val gender: String,
    val phone: String,
    val name: String,
    val location: LocationDao,
    val cell: String,
    val picture: PictureDao,
    var isUserSaved: Boolean
) : Serializable
