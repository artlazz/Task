package com.task.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.task.base.BaseAdapter
import com.task.databinding.ItemUserBinding
import com.task.domain.model.user.UserItem
import com.task.ui.diffutil.UserDiffUtilCallback
import com.task.ui.viewholder.UserViewHolder

class UserAdapter(
    private val onUserItemClick: (Int) -> Unit
) : BaseAdapter<ItemUserBinding, UserItem, UserViewHolder>(UserDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
        onItemClick = onUserItemClick
    )
}