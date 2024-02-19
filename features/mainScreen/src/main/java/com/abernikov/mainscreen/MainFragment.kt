package com.abernikov.mainscreen

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abernikov.common.BaseFragment
import com.abernikov.mainscreen.databinding.FragmentMainBinding
import com.abernikov.model.Items
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate
) {
    private lateinit var adapter: RepositoryAdapter
    private val viewModel: MainScreenViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.iconSearch.setOnClickListener {

            binding.iconSearch.visibility = View.GONE
            binding.nameApp.visibility = View.GONE
            binding.searchView.visibility = View.VISIBLE
        }
        binding.searchView.setOnCloseListener {
            binding.iconSearch.visibility = View.VISIBLE
            binding.nameApp.visibility = View.VISIBLE
            binding.searchView.visibility = View.GONE
            return@setOnCloseListener true
        }
        adapter = RepositoryAdapter(object : AdapterClickListener {
            override fun onClick(item: Items) {
                findNavController().navigate(Uri.parse("com.abernikov.searchrepositorys://details/${item.name}${item.description}${item.owner?.avatarUrl}"))
            }

        })
        binding.recyclerViewRepositorys.adapter = adapter
        binding.swipeLayout.setOnRefreshListener {
            binding.swipeLayout.isRefreshing = false

        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.query = query
                viewModel.getRepositories()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isNotBlank()) {
                    viewModel.query = newText
                    viewModel.getRepositories()
                }
                return true
            }
        })
        viewModel.observeState(viewLifecycleOwner) {
            when (it) {
                is MainScreenState.Success -> {
                    if (it.repositories!!.isNotEmpty()) {
                        adapter.submitList(it.repositories)
                    } else {
                        binding.textNotification.text = "Not found repositories"
                    }
                    binding.swipeLayout.isRefreshing = false
                    stopShimmer()
                }

                is MainScreenState.Error -> {
                    binding.swipeLayout.isRefreshing = false
                    stopShimmer()

                }

                MainScreenState.Loading -> {
                    binding.swipeLayout.isRefreshing = false
                    startShimmer()
                }
            }
        }
    }

    private fun startShimmer() {
        binding.shimmerLayout.startShimmer()
        binding.shimmerLayout.isVisible = true
        binding.recyclerViewRepositorys.isVisible = false
    }

    private fun stopShimmer() {
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.isVisible = false
        binding.recyclerViewRepositorys.isVisible = true
    }
}