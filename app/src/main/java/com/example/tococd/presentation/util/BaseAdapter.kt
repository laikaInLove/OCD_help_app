package com.example.tococd.presentation.util

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Any, VH: RecyclerView.ViewHolder>(
    areItemsTheSame: (oldItem: T, newItem: T) -> Boolean,
    areContentsTheSame: (oldItem: T, newItem: T) -> Boolean
) : ListAdapter<T, VH>(
    BaseDiffUtil<T>(
        areItemsTheSame, areContentsTheSame
    )
) {
    override fun getItemCount(): Int = currentList.count()
}

class BaseDiffUtil<T : Any>(
    val areItemsTheSameCallBack: (oldItem: T, newItem: T) -> Boolean,
    val areContentsTheSameCallback: (oldItem: T, newItem: T) -> Boolean
) : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return areItemsTheSameCallBack(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areContentsTheSameCallback(oldItem, newItem)
    }
}