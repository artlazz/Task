package com.task.data.repository.albums

import android.content.Context
import com.task.data.dataservice.apiservice.AlbumApiService
import com.task.data.dataservice.apiservice.model.AlbumItemDto
import com.task.data.dataservice.apiservice.model.PhotoItemDto
import com.task.data.dataservice.sqlservice.dao.AlbumsDao
import com.task.data.dataservice.sqlservice.dao.PhotosDao
import com.task.data.dataservice.sqlservice.model.AlbumItemDao
import com.task.data.dataservice.sqlservice.model.AlbumWithPhotosDao
import com.task.data.dataservice.sqlservice.model.PhotoItemDao
import com.task.data.executor.ServiceExecutor
import com.task.data.utils.hasNetwork
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

internal class AlbumsRepositoryImpl(
    private val context: Context,
    private val serviceExecutor: ServiceExecutor,
    private val albumApiService: AlbumApiService,
    private val albumsDao: AlbumsDao,
    private val photosDao: PhotosDao,
    private val albumItemDtoToDaoMapper: (AlbumItemDto) -> AlbumItemDao,
    private val photoItemDtoToDaoMapper: (PhotoItemDto) -> PhotoItemDao
) : AlbumsRepository {
    override suspend fun getAlbums() = serviceExecutor.execute {
        albumApiService.getAlbumsData()
    }

    override suspend fun getPhotos(albumId: Int) = serviceExecutor.execute {
        albumApiService.getPhotosData(albumId)
    }

    override suspend fun getAlbumsWithPhotos(): List<AlbumWithPhotosDao> {
        if (context.hasNetwork()) {
            serviceExecutor.execute {
                val albums = albumApiService.getAlbumsData()
                val results = mutableListOf<Deferred<List<PhotoItemDto>>>()

                albums.forEach { album ->
                    coroutineScope {
                        results.add(async { albumApiService.getPhotosData(album.id) })
                    }
                }
                val photos = results.awaitAll().flatten()

                photosDao.insertAll(photos.map { photoItemDtoToDaoMapper(it) })
                albumsDao.insertAll(albums.map { albumItemDtoToDaoMapper(it) })
            }
        }
        return albumsDao.getAlbumsWithPhotos()
    }
}