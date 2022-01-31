package com.task.data.mappers

import com.task.data.dataservice.apiservice.model.AlbumItemDto
import com.task.data.dataservice.apiservice.model.PhotoItemDto
import com.task.data.dataservice.sqlservice.model.AlbumItemDao
import com.task.data.dataservice.sqlservice.model.PhotoItemDao
import com.task.data.mappers.dto_to_dao.AlbumItemDtoToDaoMapper
import com.task.data.mappers.dto_to_dao.PhotoItemDtoToDaoMapper
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

internal val qualifierAlbumItemDtoToDaoMapper = StringQualifier("qualifierAlbumItemDtoToDaoMapper")
internal val qualifierPhotoItemDtoToDaoMapper = StringQualifier("qualifierPhotoItemDtoToDaoMapper")

internal val mappersModule = module {
    // dto to dao mappers
    factory<(AlbumItemDto) -> AlbumItemDao>(qualifierAlbumItemDtoToDaoMapper) { AlbumItemDtoToDaoMapper() }
    factory<(PhotoItemDto) -> PhotoItemDao>(qualifierPhotoItemDtoToDaoMapper) { PhotoItemDtoToDaoMapper() }
}