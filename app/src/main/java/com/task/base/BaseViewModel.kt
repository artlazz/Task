package com.task.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task.base.statemodel.ErrorStateModel
import com.task.base.statemodel.LoadingStateModel

open class BaseViewModel : ViewModel() {
    protected val _loading = MutableLiveData<LoadingStateModel>()
    val loading: LiveData<LoadingStateModel> = _loading

    protected val _error = MutableLiveData<ErrorStateModel>()
    val error: LiveData<ErrorStateModel> = _error
}