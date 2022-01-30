package com.task.fragment.home

import androidx.lifecycle.viewModelScope
import com.task.base.BaseViewModel
import com.task.base.statemodel.LoadingStateModel.LoadingInvisibleModel
import com.task.base.statemodel.LoadingStateModel.LoadingVisibleModel
import com.task.domain.model.user.UserItem
import com.task.domain.usecase.saved_users.GetSavedUsersListUseCase
import com.task.domain.usecase.seached_users.GetSearchedUsersListUseCase
import com.task.domain.usecase.users.GetUsersListUseCase
import com.task.fragment.home.HomeDataType.SAVED_USERS
import com.task.fragment.home.HomeDataType.USERS
import com.task.fragment.home.state.HomeDataState
import com.task.fragment.home.state.HomeDataState.EmptyData
import com.task.fragment.home.state.HomeDataState.UsersListData
import com.task.fragment.home.state.HomeEventState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUsersListUseCase: GetUsersListUseCase,
    private val getSearchedUsersListUseCase: GetSearchedUsersListUseCase,
    private val getSavedUsersListUseCase: GetSavedUsersListUseCase
) : BaseViewModel() {
    private val _homeDataStateCollectable = MutableStateFlow<HomeDataState>(EmptyData)
    val homeDataStateCollectable = _homeDataStateCollectable.asStateFlow()

    private val _homeSelectedTabStateCollectable = MutableStateFlow(1)
    val homeSelectedTabStateCollectable = _homeSelectedTabStateCollectable.asStateFlow()

    private val _homeEventStateCollectable = MutableSharedFlow<HomeEventState>()
    val homeEventStateCollectable = _homeEventStateCollectable.asSharedFlow()

    private val usersData = mutableListOf<UserItem>()
    private val savedUsersData = mutableListOf<UserItem>()

    private var selectedUsersType: HomeDataType = USERS
    private var searchedText: String = ""

    init {
        getUsersList(true)
    }

    fun userItemSelected(position: Int) {
        viewModelScope.launch {
            val userItem =
                (_homeDataStateCollectable.value as? UsersListData)?.data?.getOrNull(position)
            userItem?.let { item ->
                _homeEventStateCollectable.emit(HomeEventState.NavigateToUserDetail(userItem = item))
            }
        }
    }

    fun searchUsers(searchText: String) {
        viewModelScope.launch {
            if (searchText.isNotBlank()) {
                searchedText = searchText
                _loading.emit(LoadingVisibleModel)
                _homeDataStateCollectable.emit(
                    UsersListData(
                        getSearchedUsersListUseCase(
                            searchText,
                            usersData
                        )
                    )
                )
                _loading.emit(LoadingInvisibleModel)
            } else {
                _homeDataStateCollectable.emit(UsersListData(usersData))
            }
        }
    }

    fun getNewData() {
        when (selectedUsersType) {
            SAVED_USERS -> getSavedUsers(true)
            USERS -> getUsersList(true)
        }
    }

    fun getNextData() {
        if (searchedText.isNotBlank()) return
        when (selectedUsersType) {
            USERS -> getUsersList(false)
            else -> {}
        }
    }

    private fun getSavedUsers(isNewList: Boolean) {
        if (isNewList) usersData.clear()
        viewModelScope.launch {
            _loading.emit(LoadingVisibleModel)
            savedUsersData.addAll(getSavedUsersListUseCase())
            _homeDataStateCollectable.emit(UsersListData(savedUsersData))
            _loading.emit(LoadingInvisibleModel)
        }
    }

    private fun getUsersList(isNewList: Boolean) {
        if (isNewList) usersData.clear()
        viewModelScope.launch {
            _loading.emit(LoadingVisibleModel)
            usersData.addAll(getUsersListUseCase())
            _homeDataStateCollectable.emit(UsersListData(usersData))
            _loading.emit(LoadingInvisibleModel)
        }
    }

    fun saveSelectedTab(tabId: Int) {
        viewModelScope.launch {
            when (tabId) {
                1 -> selectedUsersType = USERS
                2 -> selectedUsersType = SAVED_USERS
            }
        }
    }
}