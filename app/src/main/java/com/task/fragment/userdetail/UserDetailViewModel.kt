package com.task.fragment.userdetail

import androidx.lifecycle.viewModelScope
import com.task.base.BaseViewModel
import com.task.base.statemodel.LoadingStateModel
import com.task.domain.model.user.UserItem
import com.task.domain.usecase.check_user.CheckIsSavedUserUseCase
import com.task.domain.usecase.remove_saved_user.RemoveSavedUserUseCase
import com.task.domain.usecase.save_user.SaveUserUseCase
import com.task.fragment.userdetail.state.UserDetailDataState
import com.task.fragment.userdetail.state.UserDetailDataState.UserInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserDetailViewModel(
    private val userItem: UserItem,
    private val saveUserUseCase: SaveUserUseCase,
    private val removeSavedUserUseCase: RemoveSavedUserUseCase,
    private val checkIsSavedUserUseCase: CheckIsSavedUserUseCase
) : BaseViewModel() {
    private val _userDetailDataState =
        MutableStateFlow<UserDetailDataState>(UserInfo(userItem, false))
    val userDetailDataState = _userDetailDataState.asStateFlow()

    init {
        checkIsSavedUser()
    }

    fun saveUser() {
        viewModelScope.launch {
            _loading.emit(LoadingStateModel.LoadingVisibleModel)
            saveUserUseCase(userItem)
            _userDetailDataState.emit(UserInfo(userItem, true))
            _loading.emit(LoadingStateModel.LoadingInvisibleModel)
        }
    }

    fun removeUser() {
        viewModelScope.launch {
            _loading.emit(LoadingStateModel.LoadingVisibleModel)
            removeSavedUserUseCase(userItem)
            _userDetailDataState.emit(UserInfo(userItem, false))
            _loading.emit(LoadingStateModel.LoadingInvisibleModel)
        }
    }

    private fun checkIsSavedUser() {
        viewModelScope.launch {
            _loading.emit(LoadingStateModel.LoadingVisibleModel)
            _userDetailDataState.emit(UserInfo(userItem, checkIsSavedUserUseCase(userItem.id)))
            _loading.emit(LoadingStateModel.LoadingInvisibleModel)
        }
    }
}