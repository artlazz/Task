package com.task.ui.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.task.domain.model.PhotoItem

class PhotoDiffUtil : DiffUtil.ItemCallback<PhotoItem>() {
    override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem) = oldItem == newItem
}