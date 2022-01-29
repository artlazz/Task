@file:Suppress("RedundantVisibilityModifier", "unused")

package com.task.util.extension.viewbinding

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> Fragment.viewBinding(): ViewBindingProperty<Fragment, T> =
    viewBinding(FragmentInflateViewBinder(T::class.java)::bind)

fun <F : Fragment, T : ViewBinding> Fragment.viewBinding(viewBinder: (F) -> T): ViewBindingProperty<F, T> {
    return FragmentViewBindingProperty(viewBinder)
}

private class FragmentViewBindingProperty<F : Fragment, T : ViewBinding>(
    viewBinder: (F) -> T
) : ViewBindingProperty<F, T>(viewBinder) {
    override fun getLifecycleOwner(thisRef: F) = thisRef.viewLifecycleOwner
}
class FragmentInflateViewBinder<T : ViewBinding>(
    private val viewBindingClass: Class<T>
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
    fun bind(fragment: Fragment): T {
        return bindViewMethod(null, fragment.layoutInflater) as T
    }
}
