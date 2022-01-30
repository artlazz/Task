package com.task.util.extension.activity

import android.app.Activity
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.task.R

fun Activity.showSnack(
    view: View,
    message: String,
    backgroundColorId: Int = R.color.color_main_A,
    textColorId: Int = R.color.color_text_C
) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).apply {
        setBackgroundTint(ContextCompat.getColor(this@showSnack, backgroundColorId))
        setTextColor(ContextCompat.getColor(this@showSnack, textColorId))
        show()
    }
}