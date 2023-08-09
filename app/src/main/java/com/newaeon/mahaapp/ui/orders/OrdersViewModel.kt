package com.newaeon.mahaapp.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrdersViewModel : ViewModel() {

    private val retrofitBuilder = RetrofitBuilder()

    private val _getOrders = MutableLiveData<List<MyOrdersData>?>()
    val getOrders : LiveData<List<MyOrdersData>?> = _getOrders

    private val _getOrdersError = MutableLiveData<String>()
    val getOrdersError : LiveData<String> = _getOrdersError


fun getOrders(auth : String){
    viewModelScope.launch(Dispatchers.IO){
        try {
            val userOrders = retrofitBuilder.getOrders(auth)
            _getOrders.postValue(userOrders.data)
        } catch (e:Exception) {
            _getOrdersError.postValue(e.message.toString())
        }
    }

}

}