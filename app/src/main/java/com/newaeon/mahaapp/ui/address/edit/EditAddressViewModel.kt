package com.newaeon.mahaapp.ui.address.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.network.RetrofitBuilder
import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import com.newaeon.mahaapp.ui.address.BooleanDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditAddressViewModel : ViewModel() {

    private var retrofitBuilder = RetrofitBuilder()

    private val _updateAddress = MutableLiveData<BooleanDataResponse>()
    val updateAddress : LiveData<BooleanDataResponse> = _updateAddress

    private val _updateAddressError = MutableLiveData<String>()
    val updateAddressError : LiveData<String> = _updateAddressError


    fun updateUserAddressAPI(addCustomerAddressRequest: AddCustomerAddressRequest, auth: String ){
        viewModelScope.launch (Dispatchers.IO){
            try {
            val updateUserAdd = retrofitBuilder.editUSerAddress(addCustomerAddressRequest, auth)
                _updateAddress.postValue(updateUserAdd)
            } catch (e: Exception){
                _updateAddressError.postValue(e.message.toString())
            }
            }

        }

    }


