package com.newaeon.mahaapp.ui.registration.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.SignupFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpFragment : Fragment(), OnClickListener {

    private var binding: SignupFragmentBinding? = null

    private var signupViewModel: SignupViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignupFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signupViewModel = ViewModelProvider(this)[SignupViewModel::class.java]
        observeViewModel()
        initiate()
    }

    private fun initiate() {
        binding?.btnContinue?.setOnClickListener(this)
    }

    private fun observeViewModel() {
        signupViewModel?.registrationResponse?.observe(viewLifecycleOwner) {
            findNavController().navigate(SignUpFragmentDirections.actionRegistrationToNavigationProduct3())
        }

        signupViewModel?.signupResponeError?.observe(viewLifecycleOwner) {
             binding?.errorText?.text = it.toString()
        }
    }

    private suspend fun callSignupApi() {
        signupViewModel?.callSignupApi(
            RegistrationRequestModel(
                mobileNumber = binding?.etMobileNumber?.text.toString(),
                password = binding?.etPassword?.text.toString(),
                siteCode = binding?.etSiteCode?.text.toString(),
                customerName = binding?.etName?.text.toString(),

                )

        )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.btnContinue?.id -> {
                CoroutineScope(Dispatchers.IO).launch {
                    callSignupApi()
                }

            }
        }
    }
}