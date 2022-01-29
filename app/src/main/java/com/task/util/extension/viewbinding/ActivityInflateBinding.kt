package com.task.util.extension.viewbinding

import android.app.Activity
import android.view.LayoutInflater
import androidx.core.app.ComponentActivity
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> ComponentActivity.viewBinding(
): ViewBindingProperty<ComponentActivity, T> {
    return viewBinding(ActivityInflateViewBinder(T::class.java)::bind)
}
private class ActivityViewBindingProperty<A : ComponentActivity, T : ViewBinding>(
    viewBinder: (A) -> T
) : ViewBindingProperty<A, T>(viewBinder) {

    override fun getLifecycleOwner(thisRef: A) = thisRef
}

public fun <A : ComponentActivity, T : ViewBinding> ComponentActivity.viewBinding(
    viewBinder: (A) -> T
): ViewBindingProperty<A, T> {
    return ActivityViewBindingProperty(viewBinder)
}

class ActivityInflateViewBinder<T : ViewBinding>(
    private val viewBindingClass: Class<T>,
) {

    /**
     * Cache static method `ViewBinding.inflate(LayoutInflater)`
     */
    private val bindViewMethod by lazy(LazyThreadSafetyMode.NONE) {
        viewBindingClass.getMethod("inflate", LayoutInflater::class.java)
    }

    /**
     * Create new [ViewBinding] instance
     */
    @Suppress("UNCHECKED_CAST")
    fun bind(activity: Activity): T {
        return bindViewMethod(null, activity.layoutInflater) as T
    }
}