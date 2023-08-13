package com.newaeon.mahaapp.ui.registration.signin

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
import com.newaeon.mahaapp.Constants
import com.newaeon.mahaapp.CryptoPrefsUtil
import com.newaeon.mahaapp.ProgressBarLoader
import com.newaeon.mahaapp.databinding.FragmentSigninBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SigninFragment : Fragment(), OnClickListener {


    private var progressBarLoader: ProgressBarLoader? = null


    private var signinViewModel: SigninViewModel? = null
    private var binding: FragmentSigninBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBarLoader = ProgressBarLoader(requireContext())
        signinViewModel = ViewModelProvider(this)[SigninViewModel::class.java]
        observeViewModel()
        initiate()
        checkLoggedinUser()
    }

    private fun initiate() {
        binding?.signIn?.setOnClickListener(this)
    }

    private fun observeViewModel() {
        signinViewModel?.loginResponse?.observe(viewLifecycleOwner) {
            CryptoPrefsUtil.instance.setValue(Constants.KEY_NAME, "Bearer ${it?.token}")
            findNavController().navigate(SigninFragmentDirections.actionNavigationSignInToMenu())

        }
        signinViewModel?.loginResponseError?.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        }
        signinViewModel?.showProgress?.observe(viewLifecycleOwner) {
            if (it == true)
                progressBarLoader?.show()
            else progressBarLoader?.dismiss()
        }
    }

    private fun loginRequest() =
        LoginRequest(binding?.phoneNumber?.text.toString(), binding?.password?.text.toString())

    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.signIn?.id -> CoroutineScope(Dispatchers.IO).launch {
                signinViewModel?.login(loginRequest())
            }
        }
    }

    fun checkLoggedinUser() {
        if (CryptoPrefsUtil.instance.getString(Constants.KEY_NAME)?.isNotEmpty() == true) {
            findNavController().navigate(SigninFragmentDirections.actionNavigationSignInToMenu())
        }
    }

}
