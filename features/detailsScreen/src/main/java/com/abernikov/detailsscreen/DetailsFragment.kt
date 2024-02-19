package com.abernikov.detailsscreen

import android.os.Bundle
import android.view.View
import com.abernikov.common.BaseFragment
import com.abernikov.detailsscreen.databinding.FragmentDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = (arguments?.getString("repositoryName"))
        val description = (arguments?.getString("repositoryDescription"))
        val avatar = (arguments?.getString("repositoryAvatar"))
        binding.titleTextView.text = name
        binding.descriptionTextView.text = description
        avatar.let {
            Glide.with(requireActivity())
                .asBitmap()
                .load(it)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.imageView)
        }
    }
}