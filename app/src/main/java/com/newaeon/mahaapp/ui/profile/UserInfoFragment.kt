package com.newaeon.mahaapp.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.UserInfoBinding
import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserInfoFragment : Fragment(), OnClickListener {
    private var binding: UserInfoBinding? = null
    private var userInfoViewModel: UserInfoViewModel? = null

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateSharedPrefernce()
        init()
        observeUserInfo()


    }

    private fun initiateSharedPrefernce() {
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }


    private fun observeUserInfo() {
        userInfoViewModel = ViewModelProvider(this)[UserInfoViewModel::class.java]


        userInfoViewModel?.getInfoResponse?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                userInfoViewModel!!.getUserInfoData(
                    sharedPreferences?.getString(KEY_NAME, "") ?: ""
                )
                binding?.etName?.setText(it?.data?.name.toString())
                binding?.etNumber?.setText(it?.data?.mobileNumber.toString())
                binding?.etEmail?.setText(it?.data?.email.toString())
                binding?.etSite?.setText(it?.data?.site.toString())
                binding?.etBuisnessName?.setText(it?.data?.businessName.toString())
            }
        }

        userInfoViewModel?.getInfoError?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                binding?.errorText?.text = it.toString()
            }
        }

        userInfoViewModel?.updateInfoResponse?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                activity?.onBackPressedDispatcher?.onBackPressed()
                findNavController().navigate(UserInfoFragmentDirections.actionUserInfoToMenu())
            }
        }

        userInfoViewModel?.updateInfoError?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                binding?.errorText?.text = it.toString()
            }
        }
    }


    fun init() {
        binding?.btnUpdate?.setOnClickListener(this)
    }


    fun updateInfo() = UpdateMyInfoRequest(
        name = binding?.etName?.text.toString(),
        email = binding?.etEmail?.text.toString(),
        businessName = binding?.etBuisnessName?.text.toString(),
        businessType = binding?.etBuisnessType?.text.toString(),
        site = binding?.etSite?.text.toString()
    )


    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.btnUpdate?.id -> CoroutineScope(Dispatchers.IO).launch {
                userInfoViewModel?.updateUserInfoData(
                    updateInfo(),
                    sharedPreferences?.getString(KEY_NAME, "") ?: ""
                )

            }

        }
    }
}