package com.task.fragment.details

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.betconstruct.betcocommon.util.extentions.safeLet
import com.task.base.BaseFragment
import com.task.databinding.FragmentDetailsBinding
import com.task.util.extension.viewbinding.viewBinding

class DetailsFragment : BaseFragment<DetailsViewModel, FragmentDetailsBinding>() {
    private val args: DetailsFragmentArgs by navArgs()
    override val viewModel: DetailsViewModel by viewModels()
    override val binding: FragmentDetailsBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.station?.let {
            with(it) {
                safeLet(lat, lng) { latt, lngg ->
                    viewModel.getExtremes(latt, lngg)
                    viewModel.getSeaLevels(latt, lngg)
                }
            }
        }
    }

    override fun initView() {
        args.station
    }

}