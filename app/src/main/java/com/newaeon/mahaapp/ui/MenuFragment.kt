package com.newaeon.mahaapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.MenuBinding

class MenuFragment : Fragment(), OnClickListener {
    private var binding: MenuBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetJavaScriptEnabled")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding?.tvPrivacyPolicy?.setOnClickListener(this)
        binding?.tvAboutUs?.setOnClickListener(this)
        binding?.tvAddress?.setOnClickListener(this)
        binding?.tvOrder?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding?.tvPrivacyPolicy?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/privacy.html"))


            binding?.tvAboutUs?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/privacy.html"))

            binding?.tvAddress?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToUserAddresses())
            }
            binding?.tvOrder?.id -> {findNavController().navigate(MenuFragmentDirections.actionMenuToOrder())}
        }
    }
}