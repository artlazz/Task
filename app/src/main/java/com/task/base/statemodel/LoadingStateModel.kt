package com.task.base.statemodel

sealed class LoadingStateModel {
    object LoadingVisibleModel : LoadingStateModel()
    object LoadingInvisibleModel : LoadingStateModel()
}
