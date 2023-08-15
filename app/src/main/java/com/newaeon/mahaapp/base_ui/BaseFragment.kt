package com.newaeon.mahaapp.base_ui

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

 open   fun initToolbar(){
     hide Titlehie

    }
    override fun onResume() {
        initToolbar()
        super.onResume()
    }
}