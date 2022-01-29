package com.task.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

fun <T> LifecycleOwner.collect(flow: SharedFlow<T>, block: (data: T) -> Unit) {
    lifecycleScope.launchWhenStarted {
        flow.collectLatest { block(it) }
    }
}