package com.task.ui.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.task.domain.model.AlbumWithPhotos

class AlbumWithPhotosDiffUtil : DiffUtil.ItemCallback<AlbumWithPhotos>() {
    override fun areItemsTheSame(oldItem: AlbumWithPhotos, newItem: AlbumWithPhotos) =
        oldItem.album.id == newItem.album.id

    override fun areContentsTheSame(oldItem: AlbumWithPhotos, newItem: AlbumWithPhotos) =
        oldItem.album == newItem.album
}