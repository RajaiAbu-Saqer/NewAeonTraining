package com.newaeon.mahaapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.Constants
import com.newaeon.mahaapp.CryptoPrefsUtil
import com.newaeon.mahaapp.databinding.MenuBinding
import com.newaeon.mahaapp.ui.logout.LogoutRequestModel
import com.newaeon.mahaapp.ui.logout.LogoutViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuFragment : Fragment(), OnClickListener {
    private var binding: MenuBinding? = null
    private var logoutViewModel: LogoutViewModel? = null
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
        observeViewModel()
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
            binding?.tvPrivacyPolicy?.id -> findNavController().navigate(
                MenuFragmentDirections.actionMenuToWebView(
                    "http://www.alesayidistribution.com/mobilehtml/privacy.html"
                )
            )


            binding?.tvAboutUs?.id -> findNavController().navigate(
                MenuFragmentDirections.actionMenuToWebView(
                    "http://www.alesayidistribution.com/mobilehtml/privacy.html"
                )
            )

            binding?.tvAddress?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToUserAddresses())
            }

            binding?.tvOrder?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToOrder())
            }

            binding?.tvLogout?.id -> callLogout()
            binding?.tvProfile?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToUserInfo())


        }
    }

    private fun observeViewModel() {
        logoutViewModel =
            ViewModelProvider(this)[LogoutViewModel::class.java]
        logoutViewModel?.logoutResponse?.observe(viewLifecycleOwner) {

            CoroutineScope(Dispatchers.Main).launch {
                CryptoPrefsUtil.instance.clearLogoutSessions()
                findNavController().navigate(MenuFragmentDirections.actionMenuToSignup())

            }
        }
        logoutViewModel?.logoutError?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun callLogout() {
        CoroutineScope(Dispatchers.IO).launch {
            logoutViewModel?.logoutUser(
                logoutRequestModel(),
                CryptoPrefsUtil.instance.getString(Constants.KEY_NAME) ?: ""
            )
        }
    }

    private fun logoutRequestModel() = LogoutRequestModel("")
}