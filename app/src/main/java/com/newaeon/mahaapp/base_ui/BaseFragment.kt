package com.newaeon.mahaapp.base_ui

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.newaeon.mahaapp.MainActivity
import com.newaeon.mahaapp.ProgressBarLoader


open class BaseFragment : Fragment() {
    private val progressBarLoading by lazy { ProgressBarLoader(requireContext()) }
    val mainActivity: MainActivity get() = (activity as MainActivity)
    private val myToolbar get() = mainActivity.mainBinding?.toolbar
    open fun initToolbar() {
        myToolbar?.apply {
            titleToolbar.isVisible = false
            cartToolbar.isVisible = false
        }
        toolbarVisibility(!mainActivity.isMainFragments())
    }

    fun showProgressLoading() {
        progressBarLoading.show()
    }

    fun hideProgressLoading() {
        progressBarLoading.dismiss()
    }

    fun toolbarCartButton(onClickListener: View.OnClickListener) {
        myToolbar?.cartToolbar?.isVisible = true
        myToolbar?.cartToolbar?.setOnClickListener(onClickListener)
    }

    fun toolbarVisibility(isVisible: Boolean) {
        myToolbar?.toolbarConstrain?.isVisible = isVisible
    }

    fun setToolbarTitle(title: String) {
        myToolbar?.titleToolbar?.apply {
            isVisible = true
            text = title
        }
    }


    override fun onResume() {
        initToolbar()
        super.onResume()
        mainActivity.mainBinding?.navView?.isVisible =
            mainActivity.isMainFragments()     //hide it in main fragment
    }


}