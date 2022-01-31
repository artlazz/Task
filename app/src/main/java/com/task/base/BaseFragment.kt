package com.task.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.task.base.statemodel.ErrorStateModel
import com.task.base.statemodel.LoadingStateModel

abstract class BaseFragment<ViewModel : BaseViewModel, ViewBind : ViewBinding> : Fragment() {
    protected abstract val viewModel: ViewModel
    protected abstract val binding: ViewBind
    private lateinit var navController: NavController

    private var callback: OnFragmentEventListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initCollectables()
        initView()
        initViewClickListeners()
        collectBaseChanges()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = activity as? OnFragmentEventListener
    }

    private fun collectBaseChanges() {
        with(viewModel) {
            error.observe(viewLifecycleOwner, ::handleErrorState)
            loading.observe(viewLifecycleOwner, ::handleLoadingState)
        }
    }

    private fun handleLoadingState(newLoadingState: LoadingStateModel) {
        when (newLoadingState) {
            LoadingStateModel.LoadingVisibleModel -> callback?.progressVisibilityChange(true)
            LoadingStateModel.LoadingInvisibleModel -> callback?.progressVisibilityChange(false)
        }
    }

    private fun handleErrorState(newErrorState: ErrorStateModel) {
        when (newErrorState) {
            is ErrorStateModel.DialogErrorStateModel -> callback?.showErrorDialog()
            is ErrorStateModel.SnackbarErrorStateModel -> callback?.showErrorSnackbar(newErrorState.message)
        }
    }

    protected abstract fun initView()
    protected open fun initViewClickListeners() {}
    protected open fun initCollectables() {}

    protected fun navigateFragment(navDirections: NavDirections) {
        navController.navigate(navDirections)
    }

    interface OnFragmentEventListener {
        fun progressVisibilityChange(isVisible: Boolean)
        fun showErrorSnackbar(text: String)
        fun showErrorDialog()
    }
}