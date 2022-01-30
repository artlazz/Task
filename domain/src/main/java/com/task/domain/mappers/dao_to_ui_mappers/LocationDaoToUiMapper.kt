package com.task.domain.mappers.dao_to_ui_mappers

import com.task.data.dataservice.sqlservice.model.CoordinatesDao
import com.task.data.dataservice.sqlservice.model.LocationDao
import com.task.data.dataservice.sqlservice.model.StreetDao
import com.task.data.dataservice.sqlservice.model.TimezoneDao
import com.task.domain.model.Coordinates
import com.task.domain.model.Location
import com.task.domain.model.Street
import com.task.domain.model.Timezone

internal class LocationDaoToUiMapper(
    private val streetDaoToUiMapper: (StreetDao) -> Street,
    private val timezoneDaoToUiMapper: (TimezoneDao) -> Timezone,
    private val coordinatesDaoToUiMapper: (CoordinatesDao) -> Coordinates
) : (LocationDao) -> Location {
    override fun invoke(itemDao: LocationDao) = Location(
        country = itemDao.country,
        city = itemDao.city,
        street = streetDaoToUiMapper(itemDao.street),
        timezone = timezoneDaoToUiMapper(itemDao.timezone),
        postcode = itemDao.postcode,
        coordinates = coordinatesDaoToUiMapper(itemDao.coordinates),
        state = itemDao.state
    )
}