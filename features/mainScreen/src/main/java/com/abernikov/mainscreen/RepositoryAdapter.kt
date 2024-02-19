package com.abernikov.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.abernikov.mainscreen.databinding.ItemRepositoryBinding
import com.abernikov.model.Items

class RepositoryAdapter(private val adapterClickListener: AdapterClickListener) :
    ListAdapter<Items, RepositoryViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Items, newItem: Items) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RepositoryViewHolder(
        adapterClickListener,
        ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }
}