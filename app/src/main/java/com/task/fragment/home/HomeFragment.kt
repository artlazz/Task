package com.task.fragment.home

import com.task.base.BaseFragment
import com.task.databinding.FragmentHomeBinding
import com.task.util.extension.viewbinding.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModel()
    override val binding: FragmentHomeBinding by viewBinding()

    override fun initView() {

    }
}