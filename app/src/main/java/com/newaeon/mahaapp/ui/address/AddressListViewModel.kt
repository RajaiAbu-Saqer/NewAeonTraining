package com.newaeon.mahaapp.ui.address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.network.RetrofitBuilder
import com.newaeon.mahaapp.ui.product.GetAllProductsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddressListViewModel : ViewModel() {

    private val retrofitBuilder = RetrofitBuilder()

    private val _getAddresses = MutableLiveData<CustomerAddressResponse>()
    val getAddresses: LiveData<CustomerAddressResponse> = _getAddresses


    private val _getAddressesError = MutableLiveData<String>()
    val getAddressesError: LiveData<String> = _getAddressesError

    fun getUserAdresses( auth: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userAdresses = retrofitBuilder.getUserAddresses(auth)
                _getAddresses.postValue(userAdresses)
            } catch (e: Exception) {
                _getAddressesError.postValue(e.message.toString())
                // Handle error here if needed
            }
        }

    }

}