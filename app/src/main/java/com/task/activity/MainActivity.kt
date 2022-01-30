package com.task.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.task.base.BaseFragment
import com.task.databinding.ActivityMainBinding
import com.task.util.extension.activity.showSnack
import com.task.util.extension.viewbinding.viewBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BaseFragment.OnFragmentEventListener {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun progressVisibilityChange(isVisible: Boolean) {
        lProgress.isVisible = isVisible
    }

    override fun showErrorSnackbar(text: String) {
        showSnack(binding.root, text)
    }

    override fun showErrorDialog() {
        // TODO add main error dialog
    }
}