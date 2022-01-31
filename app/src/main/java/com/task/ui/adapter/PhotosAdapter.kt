package com.task.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.task.base.BaseAdapter
import com.task.databinding.ItemPhotoBinding
import com.task.domain.model.PhotoItem
import com.task.ui.diffutil.PhotoDiffUtil
import com.task.ui.viewholder.PhotoViewHolder

class PhotosAdapter : BaseAdapter<ItemPhotoBinding, PhotoItem, PhotoViewHolder>(PhotoDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PhotoViewHolder(
        ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}