package com.task.fragment.details

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.task.base.BaseFragment
import com.task.databinding.FragmentDetailsBinding
import com.task.util.extension.viewbinding.viewBinding

class DetailsFragment : BaseFragment<DetailsViewModel, FragmentDetailsBinding>() {
    private val args: DetailsFragmentArgs by navArgs()
    override val viewModel: DetailsViewModel by viewModels()
    override val binding: FragmentDetailsBinding by viewBinding()

    override fun initView() {
        args.station
    }
}