package com.abernikov.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>(
    private val inflateBinding:
        (inflater: LayoutInflater, root: ViewGroup?, attachToRoot: Boolean) -> T
) : Fragment() {

    private var _binding: T? = null
    val binding: T
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun navigateTo(destination: String) {
        val request = NavDeepLinkRequest.Builder
            .fromUri(destination.toUri())
            .build()

        findNavController().navigate(request, navOptions)
    }

    private val navOptions =
        NavOptions.Builder()

            // подумать может сделать анимацию

            .build()
}