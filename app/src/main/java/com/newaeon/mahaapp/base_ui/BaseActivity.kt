package com.newaeon.mahaapp.base_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.databinding.ActivityMainBinding

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
}

//    override fun onBackPressed() {
//        if(currentFragment())
//
//
//            super.onBackPressed()
//    }
//}