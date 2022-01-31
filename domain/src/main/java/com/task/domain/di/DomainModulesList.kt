package com.task.domain.di

import com.task.data.di.dataModulesList
import com.task.domain.mappers.mappersModule
import com.task.domain.usecase.get_albums_with_photos.getAlbumsWithPhotosUseCaseModule

val domainModulesList = listOf(
    mappersModule,
    getAlbumsWithPhotosUseCaseModule,
) + dataModulesList