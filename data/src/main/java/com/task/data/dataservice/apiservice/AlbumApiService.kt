package com.task.data.dataservice.apiservice

import com.task.data.dataservice.apiservice.model.AlbumItemDto
import com.task.data.dataservice.apiservice.model.PhotoItemDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface AlbumApiService {
    @GET("albums")
    suspend fun getAlbumsData(
        @Query("userId") userId: Int = 1
    ): List<AlbumItemDto>

    @GET("photos")
    suspend fun getPhotosData(
        @Query("albumId") albumId: Int?
    ): List<PhotoItemDto>
}