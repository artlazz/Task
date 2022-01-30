package com.task.data.model.user

import com.task.data.model.*

data class UserItemDto(
    val idValue: String? = null,
    val nat: String? = null,
    val gender: String? = null,
    val phone: String? = null,
    val dob: DobDto? = null,
    val name: NameDto? = null,
    val registered: RegisteredDto? = null,
    val location: LocationDto? = null,
    val id: IdDto? = null,
    val login: LoginDto? = null,
    val cell: String? = null,
    val email: String? = null,
    val picture: PictureDto? = null
)
