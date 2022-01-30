package com.task.ui.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.task.domain.model.user.UserItem

class UserDiffUtilCallback : DiffUtil.ItemCallback<UserItem>() {
    override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem) = oldItem == newItem
}