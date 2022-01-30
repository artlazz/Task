package com.task.util.extension.context

import android.content.Context

fun Context.dpToPx(dp: Int) = (dp * resources.displayMetrics.density).toInt()