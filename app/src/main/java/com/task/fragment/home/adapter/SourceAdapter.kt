package com.task.fragment.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.common.model.station.Station
import com.task.databinding.ItemStationBinding
import kotlinx.android.synthetic.main.item_station.view.*

class SourceAdapter(private val onItemClick: (item: Station?) -> Unit) :
    RecyclerView.Adapter<SourceAdapter.SourceViewHolder>() {
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context
    private val stationList = mutableListOf<Station?>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder =
        SourceViewHolder(ItemStationBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        stationList[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = stationList.size

    fun updateData(listStations: List<Station?>?) {
        stationList.clear()
        listStations?.let {
            stationList.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class SourceViewHolder(itemView: ItemStationBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        init {
            itemView.root.setOnClickListener {
                onItemClick(stationList[adapterPosition])
            }
        }
        fun bind(item: Station) {
            with(itemView) {
                sourceNameText.text = item.name
                sourceText.text = item.source
            }
        }
    }
}