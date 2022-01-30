package com.task.domain.mappers

import com.task.data.dataservice.sqlservice.model.*
import com.task.data.dataservice.sqlservice.model.user.UserItemDao
import com.task.data.model.*
import com.task.data.model.user.UserItemDto
import com.task.domain.mappers.dao_to_ui_mappers.*
import com.task.domain.mappers.dto_to_ui_mappers.*
import com.task.domain.mappers.ui_to_dao_mappers.*
import com.task.domain.model.*
import com.task.domain.model.user.UserItem
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

internal val qualifierUserItemDtoToUiMapper = StringQualifier("qualifierUserItemDtoToUiMapper")
internal val qualifierCoordinatesDtoToUiMapper =
    StringQualifier("qualifierCoordinatesDtoToUiMapper")
internal val qualifierLocationDtoToUiMapper = StringQualifier("qualifierLocationDtoToUiMapper")
internal val qualifierNameDtoToUiMapper = StringQualifier("qualifierNameDtoToUiMapper")
internal val qualifierPictureDtoToUiMapper = StringQualifier("qualifierPictureDtoToUiMapper")
internal val qualifierStreetDtoToUiMapper = StringQualifier("qualifierStreetDtoToUiMapper")
internal val qualifierTimezoneDtoToUiMapper = StringQualifier("qualifierTimezoneDtoToUiMapper")

internal val qualifierUserItemUiToDaoMapper = StringQualifier("qualifierUserItemUiToDaoMapper")
internal val qualifierCoordinatesUiToDaoMapper =
    StringQualifier("qualifierCoordinatesUiToDaoMapper")
internal val qualifierLocationUiToDaoMapper = StringQualifier("qualifierLocationUiToDaoMapper")
internal val qualifierPictureUiToDaoMapper = StringQualifier("qualifierPictureUiToDaoMapper")
internal val qualifierStreetUiToDaoMapper = StringQualifier("qualifierStreetUiToDaoMapper")
internal val qualifierTimezoneUiToDaoMapper = StringQualifier("qualifierTimezoneUiToDaoMapper")

internal val qualifierUserItemDaoToUiMapper = StringQualifier("qualifierUserItemDaoToUiMapper")
internal val qualifierCoordinatesDaoToUiMapper =
    StringQualifier("qualifierCoordinatesDaoToUiMapper")
internal val qualifierLocationDaoToUiMapper = StringQualifier("qualifierLocationDaoToUiMapper")
internal val qualifierPictureDaoToUiMapper = StringQualifier("qualifierPictureDaoToUiMapper")
internal val qualifierStreetDaoToUiMapper = StringQualifier("qualifierStreetDaoToUiMapper")
internal val qualifierTimezoneDaoToUiMapper = StringQualifier("qualifierTimezoneDaoToUiMapper")

internal val mappersModule = module {
    // dto to ui
    factory<(UserItemDto) -> UserItem>(qualifierUserItemDtoToUiMapper) {
        UserItemDtoToUiMapper(
            locationDtoToUiMapper = get(qualifierLocationDtoToUiMapper),
            pictureDtoToUiMapper = get(qualifierPictureDtoToUiMapper),
            nameDtoToUiMapper = get(qualifierNameDtoToUiMapper)
        )
    }
    factory<(CoordinatesDto) -> Coordinates>(qualifierCoordinatesDtoToUiMapper) { CoordinatesDtoToUiMapper() }
    factory<(LocationDto) -> Location>(qualifierLocationDtoToUiMapper) {
        LocationDtoToUiMapper(
            streetDtoToUiMapper = get(qualifierStreetDtoToUiMapper),
            timezoneDtoToUiMapper = get(qualifierTimezoneDtoToUiMapper),
            coordinatesDtoToUiMapper = get(qualifierCoordinatesDtoToUiMapper)
        )
    }
    factory<(NameDto) -> String>(qualifierNameDtoToUiMapper) { NameDtoToUiMapper() }
    factory<(PictureDto) -> Picture>(qualifierPictureDtoToUiMapper) { PictureDtoToUiMapper() }
    factory<(StreetDto) -> Street>(qualifierStreetDtoToUiMapper) { StreetDtoToUiMapper() }
    factory<(TimezoneDto) -> Timezone>(qualifierTimezoneDtoToUiMapper) { TimezoneDtoToUiMapper() }

    // ui to dao
    factory<(UserItem) -> UserItemDao>(qualifierUserItemUiToDaoMapper) {
        UserItemUiToDaoMapper(
            locationUiToDaoMapper = get(qualifierLocationUiToDaoMapper),
            pictureUiToDaoMapper = get(qualifierPictureUiToDaoMapper)
        )
    }
    factory<(Coordinates) -> CoordinatesDao>(qualifierCoordinatesUiToDaoMapper) { CoordinatesUiToDaoMapper() }
    factory<(Location) -> LocationDao>(qualifierLocationUiToDaoMapper) {
        LocationUiToDaoMapper(
            streetUiToDaoMapper = get(qualifierStreetUiToDaoMapper),
            timezoneUiToDaoMapper = get(qualifierTimezoneUiToDaoMapper),
            coordinatesUiToDaoMapper = get(qualifierCoordinatesUiToDaoMapper)
        )
    }
    factory<(Picture) -> PictureDao>(qualifierPictureUiToDaoMapper) { PictureUiToDaoMapper() }
    factory<(Street) -> StreetDao>(qualifierStreetUiToDaoMapper) { StreetUiToDaoMapper() }
    factory<(Timezone) -> TimezoneDao>(qualifierTimezoneUiToDaoMapper) { TimezoneUiToDaoMapper() }

    // dao to ui
    factory<(UserItemDao) -> UserItem>(qualifierUserItemDaoToUiMapper) {
        UserItemDaoToUiMapper(
            locationDaoToUiMapper = get(qualifierLocationDaoToUiMapper),
            pictureDaoToUiMapper = get(qualifierPictureDaoToUiMapper)
        )
    }
    factory<(CoordinatesDao) -> Coordinates>(qualifierCoordinatesDaoToUiMapper) { CoordinatesDaoToUiMapper() }
    factory<(LocationDao) -> Location>(qualifierLocationDaoToUiMapper) {
        LocationDaoToUiMapper(
            streetDaoToUiMapper = get(qualifierStreetDaoToUiMapper),
            timezoneDaoToUiMapper = get(qualifierTimezoneDaoToUiMapper),
            coordinatesDaoToUiMapper = get(qualifierCoordinatesDaoToUiMapper)
        )
    }
    factory<(PictureDao) -> Picture>(qualifierPictureDaoToUiMapper) { PictureDaoToUiMapper() }
    factory<(StreetDao) -> Street>(qualifierStreetDaoToUiMapper) { StreetDaoToUiMapper() }
    factory<(TimezoneDao) -> Timezone>(qualifierTimezoneDaoToUiMapper) { TimezoneDaoToUiMapper() }
}