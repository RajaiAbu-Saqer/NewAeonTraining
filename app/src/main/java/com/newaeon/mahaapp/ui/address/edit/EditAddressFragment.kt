package com.newaeon.mahaapp.ui.address.edit

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
import androidx.navigation.fragment.navArgs
import com.newaeon.mahaapp.databinding.EditAddressBinding
import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import com.newaeon.mahaapp.ui.address.AddressListViewModel
import com.newaeon.mahaapp.ui.registration.signin.SigninViewModel
import com.newaeon.mahaapp.ui.registration.signup.RegistrationRequestModel
import com.newaeon.mahaapp.ui.registration.signup.SignUpFragmentDirections
import com.newaeon.mahaapp.ui.registration.signup.SignupViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditAddressFragment : Fragment() , OnClickListener{
    private var binding: EditAddressBinding? = null

     var EditAddressViewModel: EditAddressViewModel? = null


    private val navargs by navArgs<EditAddressFragmentArgs>()

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditAddressBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.etCity?.setText(navargs.addressInfo.city)
        binding?.etAddress1?.setText(navargs.addressInfo.address1)
        binding?.etAddress2?.setText(navargs.addressInfo.address2)
        binding?.etLongitude?.setText(navargs.addressInfo.longitude)
        binding?.etLatitude?.setText(navargs.addressInfo.latitude)

        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        );  // private to prevent share it  with another app

        val myAuthKey = sharedPreferences?.getString(KEY_NAME, "")


        val editAddress =
            ViewModelProvider(this)[EditAddressViewModel::class.java]
        CoroutineScope(Dispatchers.IO).launch {
            EditAddressViewModel?.updateUserAddressAPI(, myAuthKey ?: "")
            observeViewModel()
            initiate()
        }
    }


    private fun initiate() {
        binding?.btnSave?.setOnClickListener(this)
    }

    private fun observeViewModel() {
        EditAddressViewModel?.updateAddress?.observe(viewLifecycleOwner) {
            findNavController().navigate(EditAddressFragmentDirections.actionEditAddressToUserAddresses())
        }

        EditAddressViewModel?.updateAddressError?.observe(viewLifecycleOwner) {
            binding?.errorText?.text = it.toString()
        }
    }

    private suspend fun updateAddress() :AddCustomerAddressRequest {
        EditAddressViewModel?.updateUserAddressAPI(
            AddCustomerAddressRequest(
                city = binding?.etCity?.text.toString(),
                address1 = binding?.etAddress1?.text.toString(),
                address2 = binding?.etAddress2?.text.toString(),
                longitude = binding?.etLongitude?.text.toString(),
                latitude = binding?.etLatitude?.text.toString(),

            ),myAuthKey
            )
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding?.btnSave?.id -> CoroutineScope(Dispatchers.IO).launch {
                EditAddressViewModel?.updateUserAddressAPI(updateAddress(),myAuthKey)
            }
    }
}