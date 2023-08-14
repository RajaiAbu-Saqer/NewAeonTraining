package com.newaeon.mahaapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.MenuBinding
import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import com.newaeon.mahaapp.ui.logout.LogoutRequestModel
import com.newaeon.mahaapp.ui.logout.LogoutViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuFragment : Fragment(), OnClickListener {
    private var binding: MenuBinding? = null
    private var logoutViewModel : LogoutViewModel?= null


    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null


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
        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        init()
    }

    private fun init() {
        binding?.tvPrivacyPolicy?.setOnClickListener(this)
        binding?.tvAboutUs?.setOnClickListener(this)
        binding?.tvAddress?.setOnClickListener(this)
        binding?.tvOrder?.setOnClickListener(this)
        binding?.tvLogout?.setOnClickListener(this)
        binding?.tvProfile?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding?.tvPrivacyPolicy?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/privacy.html"))


            binding?.tvAboutUs?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/privacy.html"))

            binding?.tvAddress?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToUserAddresses())
            }
            binding?.tvOrder?.id -> {findNavController().navigate(MenuFragmentDirections.actionMenuToOrder())}

            binding?.tvLogout?.id -> {
                CoroutineScope(Dispatchers.IO).launch {
                    logoutViewModel?.logoutUser(logoutRequestModel(), sharedPreferences?.getString(KEY_NAME, "") ?: "")
                }
            }
            binding?.tvProfile?.id -> {findNavController().navigate(MenuFragmentDirections.actionMenuToUserInfo())}

        }
    }
    private fun logoutRequestModel() = LogoutRequestModel("")

}