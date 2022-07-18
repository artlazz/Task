package com.task.fragment.welcome

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.task.databinding.FragmentSignInBinding
import com.task.util.extension.viewbinding.viewBinding

class SignInFragment : Fragment() {

    private val binding: FragmentSignInBinding by viewBinding()
    private var isPasswordVisible = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnBack.setOnClickListener { findNavController().popBackStack() }
            etPassword.setOnTouchListener { _, motionEvent ->
                val DRAWABLE_RIGHT = 2
                if (motionEvent.action == MotionEvent.ACTION_UP) {
                    if (motionEvent.rawX >= (etPassword.right - etPassword.compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                        if (isPasswordVisible) etPassword.transformationMethod = null
                        else etPassword.transformationMethod = PasswordTransformationMethod()
                        true
                    }
                }
                false
            }
            etPassword.transformationMethod = PasswordTransformationMethod()
            etPassword.transformationMethod = null
        }
    }
}