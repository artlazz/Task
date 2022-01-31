package com.task.ui.viewholder

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.task.base.BaseViewHolder
import com.task.databinding.ItemPhotoBinding
import com.task.domain.model.PhotoItem

class PhotoViewHolder(private val binding: ItemPhotoBinding) :
    BaseViewHolder<PhotoItem, ItemPhotoBinding>(binding) {
    override fun bind(item: PhotoItem) {
        with(binding) {
            Glide.with(binding.root.context)
                .load(item.url + ".jpg") // FIXME the Glide cant load a lot of images, and throw exception, cant fix it yet
                .timeout(10000)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(ivPhoto)
        }
    }
}