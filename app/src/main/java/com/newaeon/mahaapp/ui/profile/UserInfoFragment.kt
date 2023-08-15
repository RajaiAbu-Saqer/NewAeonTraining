package com.newaeon.mahaapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.Constants
import com.newaeon.mahaapp.CryptoPrefsUtil
import com.newaeon.mahaapp.databinding.UserInfoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserInfoFragment : Fragment(), OnClickListener {
    private var binding: UserInfoBinding? = null
    private var userInfoViewModel: UserInfoViewModel? = null

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
        init()
        observeUserInfo()
        callGetUserApi()
        handleBackPress()
    }

    private fun handleBackPress() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    callUpdateInfo()
                }
            }
      )
    }

    private fun callGetUserApi() {
        CoroutineScope(Dispatchers.IO).launch {
            userInfoViewModel?.getUserInfoData(
                CryptoPrefsUtil.instance.getString(Constants.KEY_NAME) ?: ""
            )
        }

    }

    private fun observeUserInfo() {
        userInfoViewModel = ViewModelProvider(this)[UserInfoViewModel::class.java]

        userInfoViewModel?.apply {
            getInfoResponse.observe(viewLifecycleOwner) {
                CoroutineScope(Dispatchers.Main).launch {

                    binding?.etName?.setText(it?.data?.name.toString())
                    binding?.etNumber?.setText(it?.data?.mobileNumber.toString())
                    binding?.etEmail?.setText(it?.data?.email.toString())
                    binding?.etSite?.setText(it?.data?.site.toString())
                    binding?.etBuisnessName?.setText(it?.data?.businessName.toString())
                    binding?.etBuisnessType?.setText(it?.data?.businessType.toString())
                }
            }

            getInfoError.observe(viewLifecycleOwner) {
                CoroutineScope(Dispatchers.Main).launch {
                    binding?.errorText?.text = it.toString()
                }
            }

            updateInfoResponse.observe(viewLifecycleOwner) {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(activity, "Updadted", Toast.LENGTH_SHORT).show()
//                    activity?.onBackPressedDispatcher?.onBackPressed()
//                    findNavController().navigate(UserInfoFragmentDirections.actionUserInfoToMenu())
                    findNavController().popBackStack()

                }
            }

            updateInfoError.observe(viewLifecycleOwner) {
                CoroutineScope(Dispatchers.Main).launch {
                    binding?.errorText?.text = it.toString()
                }
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
            binding?.btnUpdate?.id ->callUpdateInfo()

        }
    }
    private fun callUpdateInfo(){
        CoroutineScope(Dispatchers.IO).launch {
            userInfoViewModel?.updateUserInfoData(
                updateInfo(),
                CryptoPrefsUtil.instance.getString(Constants.KEY_NAME) ?: ""
            )

        }
    }
}