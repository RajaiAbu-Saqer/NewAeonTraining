package com.newaeon.mahaapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.SplashscreenBinding


class SplashScreenFragment: Fragment() {
    private lateinit var binding: SplashscreenBinding

// to send data from screen to another
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashscreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // to send data from screen to another
        sharedPreferences =activity?. getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);  // private to prevent share it  with another app
        val editor = sharedPreferences!!.edit()
        editor.putString(KEY_NAME, "John Doe")
        editor.apply()

        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable { findNavController().navigate(SplashScreenFragmentDirections.actionNavigationSplashscreenToCreateaccount("Mahaaaa")) }
        handler.postDelayed(runnable, 5000);
    }

}