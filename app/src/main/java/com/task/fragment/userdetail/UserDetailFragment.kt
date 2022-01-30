package com.task.fragment.userdetail

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.task.R
import com.task.base.BaseFragment
import com.task.databinding.FragmentUserDetailBinding
import com.task.domain.model.user.UserItem
import com.task.fragment.userdetail.state.UserDetailDataState
import com.task.util.collect
import com.task.util.extension.viewbinding.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailFragment : BaseFragment<UserDetailViewModel, FragmentUserDetailBinding>() {
    override val viewModel: UserDetailViewModel by viewModel() {
        parametersOf(args.userItem)
    }
    override val binding: FragmentUserDetailBinding by viewBinding()
    private val args: UserDetailFragmentArgs by navArgs()

    override fun initView() {
        with(binding) {
            (activity as? AppCompatActivity)?.also {
                it.setSupportActionBar(tb)
                it.supportActionBar?.setHomeButtonEnabled(true)
                it.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    override fun initViewClickListeners() {
        with(binding) {
            btnSave.setOnClickListener { viewModel.saveUser() }
            btnRemoveUser.setOnClickListener { viewModel.removeUser() }
        }
    }

    override fun initCollectables() {
        with(viewModel) {
            collect(userDetailDataState, ::handleUserDetail)
        }
    }

    private fun handleUserDetail(data: UserDetailDataState) {
        when (data) {
            is UserDetailDataState.UserInfo -> renderUserData(data.userItem, data.isSaved)
        }
    }

    private fun renderUserData(userItem: UserItem, isSavedUser: Boolean) {
        with(binding) {
            tb.title = userItem.name
            tvName.text = userItem.name
            tvSexAndPhone.text =
                root.context.getString(
                    R.string.global_paramString_comma_2,
                    userItem.gender,
                    userItem.phone
                )
            tvCountry.text = userItem.location.country
            tvAddress.text =
                root.context.getString(
                    R.string.global_paramString_space_3,
                    userItem.location.street.number.toString(),
                    userItem.location.street.name,
                    userItem.location.city
                )

            Glide.with(root.context)
                .load(userItem.picture.large)
                .circleCrop()
                .into(ivAvatar)

            if (isSavedUser) {
                btnSave.text = getString(R.string.global_user_saved)
                btnSave.isEnabled = false
                btnRemoveUser.isVisible = true
            } else {
                btnSave.text = getString(R.string.global_save_user)
                btnSave.isEnabled = true
                btnRemoveUser.isVisible = false
            }

            loadMap(userItem)
        }
    }

    private fun loadMap(userItem: UserItem) {
        val callback = OnMapReadyCallback { googleMap ->
            val sydney = LatLng(
                userItem.location.coordinates.latitude.toDouble(),
                userItem.location.coordinates.longitude.toDouble()
            )
            googleMap.addMarker(MarkerOptions().position(sydney).title(""))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            googleMap.uiSettings.setAllGesturesEnabled(false)
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}