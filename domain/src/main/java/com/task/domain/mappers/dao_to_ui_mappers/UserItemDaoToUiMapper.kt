package com.task.domain.mappers.dao_to_ui_mappers

import com.task.data.dataservice.sqlservice.model.LocationDao
import com.task.data.dataservice.sqlservice.model.PictureDao
import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.domain.model.Location
import com.task.domain.model.Picture
import com.task.domain.model.user.UserItem

internal class UserItemDaoToUiMapper(
    private val locationDaoToUiMapper: (LocationDao) -> Location,
    private val pictureDaoToUiMapper: (PictureDao) -> Picture,
) : (UserItemDao) -> UserItem {
    override fun invoke(itemDao: UserItemDao) = UserItem(
        gender = itemDao.gender,
        phone = itemDao.phone,
        name = itemDao.name,
        location = locationDaoToUiMapper(itemDao.location),
        id = itemDao.id,
        cell = itemDao.cell,
        picture = pictureDaoToUiMapper(itemDao.picture),
    )
}