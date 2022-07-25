package com.task.fragment.stations.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.task.base.BaseAdapter
import com.task.base.BaseViewHolder
import com.task.common.model.stations.Stations
import com.task.databinding.ItemStationsBinding

class StationsAdapter(
    private val onItemClick: (Stations) -> Unit
) :
    BaseAdapter<ItemStationsBinding, Stations, StationsAdapter.StationsViewHolder>(
        StationsDiffUtilCallBack()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationsViewHolder {
        val inflate = ItemStationsBinding.bind(parent)
        return StationsViewHolder(inflate, onItemClick)
    }

    inner class StationsViewHolder(
        private val itemStationsBinding: ItemStationsBinding,
        private val onItemClick: (Stations) -> Unit
    ) :
        BaseViewHolder<Stations, ItemStationsBinding>(itemStationsBinding) {
        override fun bind(item: Stations) {
            with(itemStationsBinding) {
                tvStationsName.text = item.name
                tvLatitude.text = item.latitude.toString()
                tvLongitude.text = item.longitude.toString()
                tvSource.text = item.source
                llParent.setOnClickListener {
                    onItemClick(item)
                }
            }
        }
    }

    class StationsDiffUtilCallBack : DiffUtil.ItemCallback<Stations>() {
        override fun areItemsTheSame(oldItem: Stations, newItem: Stations): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Stations, newItem: Stations): Boolean =
            oldItem.latitude == newItem.latitude
    }
}