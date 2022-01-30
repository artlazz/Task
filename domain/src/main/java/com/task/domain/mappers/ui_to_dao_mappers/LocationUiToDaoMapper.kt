package com.task.domain.mappers.ui_to_dao_mappers

import com.task.data.dataservice.sqlservice.model.CoordinatesDao
import com.task.data.dataservice.sqlservice.model.LocationDao
import com.task.data.dataservice.sqlservice.model.StreetDao
import com.task.data.dataservice.sqlservice.model.TimezoneDao
import com.task.domain.model.Coordinates
import com.task.domain.model.Location
import com.task.domain.model.Street
import com.task.domain.model.Timezone

internal class LocationUiToDaoMapper(
    private val streetUiToDaoMapper: (Street) -> StreetDao,
    private val timezoneUiToDaoMapper: (Timezone) -> TimezoneDao,
    private val coordinatesUiToDaoMapper: (Coordinates) -> CoordinatesDao
) : (Location) -> LocationDao {
    override fun invoke(item: Location) = LocationDao(
        country = item.country,
        city = item.city,
        street = streetUiToDaoMapper(item.street),
        timezone = timezoneUiToDaoMapper(item.timezone),
        postcode = item.postcode,
        coordinates = coordinatesUiToDaoMapper(item.coordinates),
        state = item.state
    )
}