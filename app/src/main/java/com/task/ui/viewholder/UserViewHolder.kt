package com.task.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.task.R
import com.task.base.BaseViewHolder
import com.task.databinding.ItemUserBinding
import com.task.domain.model.user.UserItem

class UserViewHolder(
    private val binding: ItemUserBinding,
    private val onItemClick: (Int) -> Unit
) : BaseViewHolder<UserItem, ItemUserBinding>(binding) {

    init {
        itemView.setOnClickListener {
            adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                ?.let { onItemClick(adapterPosition) }
        }
    }

    override fun bind(item: UserItem) {
        with(binding) {
            tvName.text = item.name
            tvSexAndPhone.text =
                root.context.getString(R.string.global_paramString_comma_2, item.gender, item.phone)
            tvCountry.text = item.location.country
            tvAddress.text =
                root.context.getString(
                    R.string.global_paramString_space_3,
                    item.location.street.number.toString(),
                    item.location.street.name,
                    item.location.city
                )

            Glide.with(root.context)
                .load(item.picture.medium)
                .transform(CenterCrop(), RoundedCorners(6))
                .into(ivAvatar)
        }
    }
}