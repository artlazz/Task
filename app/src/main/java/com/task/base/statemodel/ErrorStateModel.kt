package com.task.base.statemodel

import android.os.Parcelable
import com.task.common.util.EMPTY
import kotlinx.android.parcel.Parcelize

sealed class ErrorStateModel {
    @Parcelize
    class DialogErrorStateModel(
        val tag: String = String.EMPTY,
        val title: CharSequence? = null,
        val message: CharSequence,
        val positiveButtonTitle: CharSequence? = null,
        val negativeButtonTitle: CharSequence? = null,
        val neutralButtonTitle: CharSequence? = null
    ) : ErrorStateModel(), Parcelable

    @Parcelize
    class SnackbarErrorStateModel(
        val message: String
    ) : ErrorStateModel(), Parcelable
}
