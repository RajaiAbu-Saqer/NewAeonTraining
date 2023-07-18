package com.newaeon.mahaapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.newaeon.mahaapp.databinding.CreateaccountFragmentBinding

class CreateAccountFragment : Fragment() {
    private lateinit var binding: CreateaccountFragmentBinding

    // send data from screen to another
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CreateaccountFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val message = sharedPreferences?.getString(KEY_NAME, "");
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()

        binding.ETFullName.setOnClickListener() {
            if (binding.ETFullName.text.toString().length <= 3) {
                Toast.makeText(activity, "Invalide name", Toast.LENGTH_SHORT).show()
            }
            var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

            binding.ETEmailReg.text.toString().trim().apply {
                if (matches(emailPattern.toRegex()) && length <= 8) {

                }

            }
        }
    }
}