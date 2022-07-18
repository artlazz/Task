package com.task.fragment.welcome

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.task.R
import com.task.databinding.FragmentWelcomeBinding
import com.task.util.extension.viewbinding.viewBinding


class WelcomeFragment : Fragment() {
    private val binding: FragmentWelcomeBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvLanguage.setOnClickListener { showPickLanguagePopApp() }
    }

    private fun showPickLanguagePopApp() {
        val wrapper: Context = ContextThemeWrapper(context, R.style.GlyzrPopupMenu)
        val popup = PopupMenu(wrapper, binding.tvLanguage)
        popup.menuInflater.inflate(R.menu.pick_language_menu, popup.menu)
        popup.setOnMenuItemClickListener {
            val language = when (it.itemId) {
                R.id.english -> getString(R.string.label_language_en)
                R.id.armenian -> getString(R.string.label_language_hy)
                R.id.russian -> getString(R.string.label_language_ru)
                else -> ""
            }
            binding.tvLanguage.text = language
            true
        }

        popup.show() //showing popup menu

    }
}