package com.newaeon.mahaapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.newaeon.mahaapp.base_ui.BaseFragment
import com.newaeon.mahaapp.databinding.FragmentNewBinding
import com.newaeon.mahaapp.ui.create_account.UserInfoModel

class News : BaseFragment() {
    private lateinit var binding: FragmentNewBinding
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "KEY_MY_DATA"
    private var sharedPreferences: SharedPreferences? = null

    private val newsArgs by navArgs<NewsArgs>()
        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val jsonString = sharedPreferences?.getString(KEY_NAME, null)
        val gson = Gson()
        jsonString?.let { gson.fromJson(it, UserInfoModel::class.java) }





            ?.let {
            binding.etFullNamev.text = "My Name : ${it.fullname}"
            binding.etEmailregv.text = "Email : ${it.email}"
            binding.etNationalIdv.text = "National ID: ${(it.nationalID)}"
            binding.etPhonenumberv.text = "Phone Number : ${it.phonenumber}"
            binding.etBirthv.text = "Date of Birthe: ${it.dataOfBirth}"
        }

        newsArgs.notificationModel?.let{
            Toast.makeText(activity, it.firstDescription, Toast.LENGTH_SHORT).show()
        }
    }
}


