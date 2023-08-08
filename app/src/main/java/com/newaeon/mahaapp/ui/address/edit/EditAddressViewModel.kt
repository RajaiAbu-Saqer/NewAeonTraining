package com.newaeon.mahaapp.ui.address.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.network.RetrofitBuilder
import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditAddressViewModel : ViewModel() {

    private var retrofitBuilder = RetrofitBuilder()

    private val _updateAddress = MutableLiveData<Boolean?>()
    val updateAddress: LiveData<Boolean?> = _updateAddress

    private val _updateAddressError = MutableLiveData<String>()
    val updateAddressError: LiveData<String> = _updateAddressError


    fun updateUserAddressAPI(addCustomerAddressRequest: AddCustomerAddressRequest, auth: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = retrofitBuilder.editUSerAddress(addCustomerAddressRequest, auth)
                if (response.data == true) {
                    _updateAddress.postValue(true)
                } else {
                    _updateAddressError.postValue("Error: $response ")
                }
            } catch (e: Exception) {
                _updateAddressError.postValue("An error occurred: ${e.message}")
            }
        }
    }

}


