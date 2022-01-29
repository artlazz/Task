package com.task.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<Item, ItemViewBinding : ViewBinding>(binding: ItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: Item)
}