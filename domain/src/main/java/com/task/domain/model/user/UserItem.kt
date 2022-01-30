package com.task.domain.model.user

import com.task.domain.model.Location
import com.task.domain.model.Picture
import java.io.Serializable

data class UserItem(
    val gender: String,
    val phone: String,
    val name: String,
    val location: Location,
    val id: String,
    val cell: String,
    val picture: Picture,
) : Serializable
