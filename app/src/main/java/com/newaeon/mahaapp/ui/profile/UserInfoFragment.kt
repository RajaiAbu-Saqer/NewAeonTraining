package com.newaeon.mahaapp.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.UserInfoBinding
import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserInfoFragment : Fragment() , OnClickListener {
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
        observerUserInfo()
   
    }

    private fun initiateSharedPrefernce() {
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE)
    }


    private fun observerUserInfo() {
        userInfoViewModel = ViewModelProvider(this)[UserInfoViewModel::class.java]

        userInfoViewModel?.getInfoResponse?.observe(viewLifecycleOwner)
        {
            CoroutineScope(Dispatchers.Main).launch {
                userInfoViewModel!!.getUserInfoData(
                    sharedPreferences?.getString(KEY_NAME, "") ?: ""
                )
               }
            init()
        }

        userInfoViewModel?.getInfoError?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                binding?.errorText?.text = it.toString()
            }
        }
    }


    fun init(){
        binding?.btnUpdate?.setOnClickListener(this)

        userInfoViewModel?.getInfoResponse?.observe(viewLifecycleOwner) {
            binding?.etName?.setText(it?.data?.name.toString())
            binding?.etNumber?.setText(it?.data?.mobileNumber.toString())
            binding?.etEmail?.setText(it?.data?.email.toString())
            binding?.etSite?.setText(it?.data?.site.toString())
            binding?.etBuisnessName?.setText(it?.data?.businessName.toString())
        }
    }

    override fun onClick(v: View?) {

    }
}