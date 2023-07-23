package com.newaeon.mahaapp.ui.create_account

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.newaeon.mahaapp.databinding.CreateaccountFragmentBinding
import com.newaeon.mahaapp.ui.RegistrationFragmentDirections

class CreateAccountFragment : Fragment() ,OnClickListener{
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

    private fun userInfoMode() = UserInfoModel(
        fullname = binding.ETFullName.text.toString(),
        email = binding.ETEmailReg.text.toString(),
        nationalID = binding.ETNationalId.text.toString(),
        phonenumber = binding.ETPhoneNumber.text.toString(),
        dataOfBirth = binding.ETBirth.text.toString(),
        password = binding.ETPassReg.text.toString()
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener(this)

//        binding.btnRegister.setOnClickListener() {
//            if (binding.ETFullName.text.toString().length <= 3) {
//                Toast.makeText(activity, "Invalide name", Toast.LENGTH_SHORT).show()
//            }
//            var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
//
//            binding.ETEmailReg.text.toString().trim().apply {
//                if (matches(emailPattern.toRegex()) && length <= 8) {
//
//
//                }
//
//            }
//        }

    }

    var number=10
    private fun saveUserInfo(){
        // Convert the object to a JSON string
        val gson = Gson()
        val jsonString = gson.toJson(userInfoMode() )

        // Save the JSON string in SharedPreferences
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        );  // private to prevent share it  with another app
        val editor = sharedPreferences?.edit()
        editor?.putString("KEY_MY_DATA", jsonString)
        editor?.apply()

}

    override fun onClick(v: View?) {
//       when (number){
//           1->{}
//           2->{}
//       }
        when(v?.id){
            binding.btnRegister.id->{
                saveUserInfo()
                findNavController().navigate(RegistrationFragmentDirections.actionCreateaccountToNavigationDashboard())
            }
        }

    }
}