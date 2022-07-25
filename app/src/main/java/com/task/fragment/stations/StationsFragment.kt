package com.task.fragment.stations

import androidx.lifecycle.lifecycleScope
import com.task.base.BaseFragment
import com.task.databinding.FragmentStationsBinding
import com.task.fragment.stations.adapter.StationsAdapter
import com.task.util.extension.viewbinding.viewBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class StationsFragment : BaseFragment<StationsViewModel, FragmentStationsBinding>() {
    override val viewModel: StationsViewModel by viewModel()
    override val binding: FragmentStationsBinding by viewBinding()

    private val stationsAdapter = StationsAdapter {
        //do some action for item click
    }

    override fun initView() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.stationsData.collectLatest {
                stationsAdapter.submitList(it)
            }
        }
    }
}