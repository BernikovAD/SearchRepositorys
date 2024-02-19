package com.abernikov.mainscreen

import androidx.recyclerview.widget.RecyclerView
import com.abernikov.mainscreen.databinding.ItemRepositoryBinding
import com.abernikov.model.Items
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class RepositoryViewHolder(
    private val adapterClickListener: AdapterClickListener,
    private val binding: ItemRepositoryBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Items) {
        binding.titleTextView.text = repository.name
        binding.descriptionTextView.text = repository.description
        repository.owner?.avatarUrl.let {
            Glide.with(itemView.context)
                .asBitmap()
                .load(it)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.imageView)
        }
        binding.root.setOnClickListener {
            adapterClickListener.onClick(item = repository)
        }
    }
}