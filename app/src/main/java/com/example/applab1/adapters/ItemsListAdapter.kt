package com.example.applab1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.applab1.data.Item
import com.example.applab1.databinding.BigCardBinding
import com.example.applab1.databinding.SmallCardBinding

class ItemsListAdapter(private val onItemClick: (u: Item) -> Unit): ListAdapter<Item, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        println("onCreateViewHolder")
        return when (viewType) {
            0 -> {
                val binding = SmallCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                SmallItemHolder(binding)
            }
            else -> {
                val binding = BigCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                BigItemHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        println("getItemViewType")
        return when (getItem(position).viewType) {
            0 -> 0
            1 -> 1
            else -> throw Exception("Not found viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        println("onBindViewHolder")
        when (holder.itemViewType) {
            0 -> (holder as SmallItemHolder).bind((getItem(position) as Item.SmallItem), onItemClick)
            1 -> (holder as BigItemHolder).bind((getItem(position) as Item.BigItem), onItemClick)
            else -> throw Exception("Not found itemViewType")
        }
    }

}

class MyDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        println("areItemsTheSame")
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        println("areContentsTheSame")
        return oldItem == newItem
    }
}

class SmallItemHolder(private val binding: SmallCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item.SmallItem, onItemClick: (u: Item) -> Unit) = with (binding) {
        println("SmallItemHolder bind")
        headerThings.header.text = item.header
        headerThings.subheadForHeader.text = item.subheadForHeader
        itemView.rootView.setOnClickListener { onItemClick(
            item
        ) }
    }
}

class BigItemHolder(private val binding: BigCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item.BigItem, onItemClick: (u: Item) -> Unit) = with (binding) {
        println("BigItemHolder bind")
        headerThings.header.text = item.header
        headerThings.subheadForHeader.text = item.subheadForHeader
        title.text = item.title
        subheadForTitle.text = item.subheadForTitle
        description.text = item.description
        itemView.rootView.setOnClickListener { onItemClick(
            item
        ) }
    }
}

