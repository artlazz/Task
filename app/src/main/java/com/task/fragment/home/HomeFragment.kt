package com.task.fragment.home

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.task.base.BaseFragment
import com.task.databinding.FragmentHomeBinding
import com.task.domain.model.AlbumWithPhotos
import com.task.fragment.home.datastate.HomeDataState
import com.task.ui.adapter.AlbumsAdapter
import com.task.util.extension.viewbinding.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModel()
    override val binding: FragmentHomeBinding by viewBinding()

    private val albumsAdapter: AlbumsAdapter = AlbumsAdapter()

    override fun initView() {
        with(binding) {
            rvAlbums.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = albumsAdapter
            }
        }
    }

    override fun initCollectables() {
        with(viewModel) {
            homeDataState.observe(viewLifecycleOwner, ::handleData)
        }
    }

    private fun handleData(data: HomeDataState) {
        when (data) {
            is HomeDataState.AlbumsList -> submitAlbumsList(data.list)
        }
    }

    private fun submitAlbumsList(list: List<AlbumWithPhotos>) {
        albumsAdapter.submitList(list)
    }
}