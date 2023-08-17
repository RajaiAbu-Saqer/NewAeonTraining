package com.newaeon.mahaapp.base_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.newaeon.mahaapp.ProgressBarLoader
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.databinding.ActivityMainBinding
import com.newaeon.mahaapp.ui.dashboard.DashboardFragment
import com.newaeon.mahaapp.ui.home.HomeFragment
import com.newaeon.mahaapp.ui.notifications.NotificationsFragment

open class BaseActivity : AppCompatActivity() {
    var mainBinding: ActivityMainBinding? = null
    lateinit var navController: NavController
    protected lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)
        navView = mainBinding?.navView!!
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        mainBinding?.toolbar?.backToolbar?.setOnClickListener {
            onBackPressed()
        }
    }


    private fun getCurrentFragment() =
        supportFragmentManager.fragments[0].childFragmentManager.fragments[0]

    fun isMainFragments() =
        getCurrentFragment() is NotificationsFragment || getCurrentFragment() is DashboardFragment || getCurrentFragment() is HomeFragment

    override fun onBackPressed() {
        if (isMainFragments()) moveTaskToBack(true)
        else onBackPressedDispatcher.onBackPressed()
    }

}