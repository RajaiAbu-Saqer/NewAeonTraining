package com.newaeon.mahaapp.base_ui

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.newaeon.mahaapp.MainActivity
import com.newaeon.mahaapp.ui.notifications.NotificationsFragment


open class BaseFragment : Fragment() {

    val mainActivity: MainActivity get() = (activity as MainActivity)
    private val myToolbar get() = mainActivity.mainBinding?.toolbar
    open fun initToolbar() {
        myToolbar?.apply {
            titleToolbar.isVisible = false
            cartToolbar.isVisible = false
        }
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

    fun getCurrentFragment() {
//        val currentDestination = (activity as MainActivity).navController.currentDestination
//        val currentDestinationClassName: String = currentDestination?.javaClass?.name ?: ""
//        (activity as MainActivity).mainBinding?.navView?.isVisible =
//            currentDestinationClassName == DashboardFragment::class.java.name
//


        val currentDestination =
            mainActivity.supportFragmentManager.fragments.firstOrNull()
//        val currentDestinationClassName: String = currentDestination?.javaClass?.name ?: ""
        mainActivity.mainBinding?.navView?.isVisible =
            currentDestination == NotificationsFragment::class.java


    }


    override fun onResume() {
        initToolbar()
        super.onResume()
//        getCurrentFragment()

    }
}