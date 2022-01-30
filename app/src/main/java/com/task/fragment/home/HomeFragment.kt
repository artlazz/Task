package com.task.fragment.home

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.task.R
import com.task.base.BaseFragment
import com.task.common.util.EMPTY
import com.task.databinding.FragmentHomeBinding
import com.task.domain.model.user.UserItem
import com.task.fragment.home.state.HomeDataState
import com.task.fragment.home.state.HomeEventState
import com.task.ui.adapter.UserAdapter
import com.task.util.collect
import com.task.util.extension.edittext.textChanges
import com.task.util.extension.viewbinding.viewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.stateViewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by stateViewModel()
    override val binding: FragmentHomeBinding by viewBinding()

    private lateinit var usersAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usersAdapter = UserAdapter(::onUserItemClick)
    }

    override fun initView() {
        with(binding) {
            tabLayout.addTab(
                tabLayout.newTab().setId(TAB_USERS).setText(getString(R.string.global_users))
            )
            tabLayout.addTab(
                tabLayout.newTab().setId(TAB_SAVED_USERS)
                    .setText(getString(R.string.global_saved_users))
            )
            rvUsers.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = usersAdapter
                addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            }
        }
    }

    override fun initViewClickListeners() {
        with(binding) {
            etSearch.textChanges().debounce(300)
                .onEach { viewModel.searchUsers(it.toString()) }
                .launchIn(lifecycleScope)

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    viewModel.saveSelectedTab(tab?.id ?: TAB_USERS)
                    viewModel.getNewData()
                    etSearch.setText(String.EMPTY)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
            rvUsers.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    (rvUsers.layoutManager as? LinearLayoutManager)?.also {
                        val visibleItemCount: Int = it.childCount
                        val totalItemCount: Int = it.itemCount
                        val firstVisibleItemPosition: Int = it.findFirstVisibleItemPosition()

                        if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && totalItemCount >= PAGE_SIZE) {
                            viewModel.getNextData()
                        }
                    }
                }
            })
        }
    }

    override fun initCollectables() {
        with(viewModel) {
            collect(homeEventStateCollectable, ::handleHomeEvent)
            collect(homeDataStateCollectable, ::handleHomeState)
        }
    }

    private fun onUserItemClick(position: Int) {
        viewModel.userItemSelected(position)
    }

    private fun handleHomeEvent(event: HomeEventState) {
        when (event) {
            is HomeEventState.NavigateToUserDetail -> navigateToDetail(event.userItem)
        }
    }

    private fun handleHomeState(data: HomeDataState) {
        when (data) {
            HomeDataState.EmptyData -> {}
            is HomeDataState.UsersListData -> submitUsersNewList(data.data)
        }
    }

    private fun navigateToDetail(userItem: UserItem) {
        navigateFragment(HomeFragmentDirections.actionToUserDetailFragment(userItem))
    }

    private fun submitUsersNewList(data: List<UserItem>) {
        lifecycleScope.launch {
            delay(100)
            usersAdapter.submitList(data)
        }
    }

    companion object {
        private const val TAB_USERS = 1
        private const val TAB_SAVED_USERS = 2
    }
}