package com.newaeon.mahaapp.ui.logout

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.databinding.FragmentLogoutBinding
import com.newaeon.mahaapp.ui.address.edit.EditAddressViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogoutFragment : Fragment() {
    private var binding: FragmentLogoutBinding? = null
    private var logoutViewModel : LogoutViewModel ?= null

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogoutBinding.inflate(inflater, container, false)
        return binding?.root
//        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
//        val editor = sharedPreferences?.edit()
//        editor?.remove("KEY_NAME")
//        editor?.apply()
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            observeViewModel()
            initSharedPreferences()
        }


    fun observeViewModel() {
        logoutViewModel =
            ViewModelProvider(this)[LogoutViewModel::class.java]
        logoutViewModel?.logoutResponse?.observe(viewLifecycleOwner) {

            CoroutineScope(Dispatchers.Main).launch {
                if (it == true) {
                    val editor = sharedPreferences?.edit()
                    editor?.remove("KEY_NAME")
                    editor?.apply()
                    findNavController().navigate(LogoutFragmentDirections.actionLogoutToSignup())
                }
                else Toast.makeText(activity, "No", Toast.LENGTH_SHORT).show()
            }
        }
        logoutViewModel?.logoutError?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                binding?.errorText?.text = it.toString()
            }
        }
    }

    fun initSharedPreferences() {
    sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    }
}
