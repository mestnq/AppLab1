package com.example.applab1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.applab1.data.Item
import com.example.applab1.databinding.BigCardBinding
import com.example.applab1.databinding.SmallCardBinding
//todo LISTENER
class ItemsListAdapter: ListAdapter<Item, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
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
        return when (getItem(position).viewType) {
            0 -> 0
            1 -> 1
            else -> throw Exception("Not found viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as SmallItemHolder).bind(getItem(position) as Item.SmallItem)
            1 -> (holder as BigItemHolder).bind(getItem(position) as Item.BigItem)
            else -> throw Exception("Not found itemViewType")
        }
    }

}

class MyDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}

class SmallItemHolder(private val binding: SmallCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item.SmallItem) = with (binding) {
        headerThings.header.text = item.header
        headerThings.subheadForHeader.text = item.subheadForHeader
    }
}

class BigItemHolder(private val binding: BigCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item.BigItem) = with (binding) {
        headerThings.header.text = item.header
        headerThings.subheadForHeader.text = item.subheadForHeader
        title.text = item.title
        subheadForTitle.text = item.subheadForTitle
        description.text = item.description
    }
}

