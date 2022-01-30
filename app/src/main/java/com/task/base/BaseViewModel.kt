package com.task.base

import androidx.lifecycle.ViewModel
import com.task.base.statemodel.ErrorStateModel
import com.task.base.statemodel.LoadingStateModel
import com.task.base.statemodel.LoadingStateModel.LoadingInvisibleModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

open class BaseViewModel : ViewModel() {
    protected val _loading = MutableStateFlow<LoadingStateModel>(LoadingInvisibleModel)
    val loading = _loading.asSharedFlow()

    protected val _error = MutableSharedFlow<ErrorStateModel>()
    val error = _error.asSharedFlow()
}