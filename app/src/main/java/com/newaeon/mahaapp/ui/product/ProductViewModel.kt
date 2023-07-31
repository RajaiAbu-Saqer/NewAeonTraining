package com.newaeon.mahaapp.ui.product

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val retrofitBuilder = RetrofitBuilder()


    private val _productResponse = MutableLiveData<GetAllProductsResponse>()
    val productResponse: LiveData<GetAllProductsResponse> = _productResponse


    private val _productResponseError = MutableLiveData<String>()
    val productResponseError: LiveData<String> = _productResponseError
    suspend fun getAllProduct() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val productsResponse = retrofitBuilder.getAllProduct()
                _productResponse.postValue(productsResponse)
            } catch (e: Exception) {
                _productResponseError.postValue(e.message.toString())
                // Handle error here if needed
            }
        }
    }
}