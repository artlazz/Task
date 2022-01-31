package com.task.ui.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import com.task.base.BaseViewHolder
import com.task.databinding.ItemAlbumBinding
import com.task.domain.model.AlbumWithPhotos
import com.task.ui.adapter.PhotosAdapter

class AlbumsViewHolder(private val binding: ItemAlbumBinding) :
    BaseViewHolder<AlbumWithPhotos, ItemAlbumBinding>(binding) {

    override fun bind(item: AlbumWithPhotos) {
        with(binding) {
            tvTitle.text = item.album.title

            val photosAdapter = PhotosAdapter()

            rvPhotos.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = photosAdapter
            }

            photosAdapter.submitList(item.photos)
        }
    }
}