package com.task.fragment.home

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.betconstruct.betcocommon.util.extentions.safeLet
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.task.base.BaseFragment
import com.task.common.model.station.Station
import com.task.databinding.FragmentHomeBinding
import com.task.fragment.home.adapter.SourceAdapter
import com.task.util.extension.viewbinding.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModel()
    override val binding: FragmentHomeBinding by viewBinding()
    private val adapter = SourceAdapter {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)) }
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            fusedLocationClient.lastLocation.addOnSuccessListener {
                safeLet(it.latitude,it.longitude){latitude,longitude->
                    viewModel.getStations(latitude,longitude)
                }
//                viewModel.getFakeStations()
            }
        } else {
            // Explain to the user that the feature is unavailable because themapkit
            // features requires a permission that the user has denied. At the
            // same time, respect the user's decision. Don't link to system
            // settings in an effort to convince the user to change their
            // decision.
        }
    }

    override fun initCollectables() {
        super.initCollectables()
        viewModel.stationLiveDat.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
    }

    override fun initView() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        binding.stationRV.adapter = adapter
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

}