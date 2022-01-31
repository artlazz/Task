package com.task.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.task.base.BaseAdapter
import com.task.databinding.ItemAlbumBinding
import com.task.domain.model.AlbumWithPhotos
import com.task.ui.diffutil.AlbumWithPhotosDiffUtil
import com.task.ui.viewholder.AlbumsViewHolder

class AlbumsAdapter : BaseAdapter<ItemAlbumBinding, AlbumWithPhotos, AlbumsViewHolder>(
    AlbumWithPhotosDiffUtil()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumsViewHolder(
        ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}