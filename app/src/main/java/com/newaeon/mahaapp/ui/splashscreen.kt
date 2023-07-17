package com.newaeon.mahaapp.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.SplashscreenBinding

class SplashScreenFragment: Fragment() {
    private lateinit var binding: SplashscreenBinding
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
        val handler = Handler()
        val runnable = Runnable { findNavController().navigate(SplashScreenFragmentDirections.actionNavigationSplashscreenToNavigationDashboard()) }
        handler.postDelayed(runnable, 5000);
    }

}