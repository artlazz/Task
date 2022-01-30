package com.task.domain.mappers.ui_to_dao_mappers

import com.task.data.dataservice.sqlservice.model.LocationDao
import com.task.data.dataservice.sqlservice.model.PictureDao
import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.domain.model.Location
import com.task.domain.model.Picture
import com.task.domain.model.user.UserItem

internal class UserItemUiToDaoMapper(
    private val locationUiToDaoMapper: (Location) -> LocationDao,
    private val pictureUiToDaoMapper: (Picture) -> PictureDao,
) : (UserItem) -> UserItemDao {
    override fun invoke(item: UserItem) = UserItemDao(
        gender = item.gender,
        phone = item.phone,
        name = item.name,
        location = locationUiToDaoMapper(item.location),
        id = item.id,
        cell = item.cell,
        picture = pictureUiToDaoMapper(item.picture),
        isUserSaved = false
    )
}