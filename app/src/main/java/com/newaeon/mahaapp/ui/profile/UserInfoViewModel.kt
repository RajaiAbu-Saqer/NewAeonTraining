package com.newaeon.mahaapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.BaseError
import com.newaeon.mahaapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Error

class UserInfoViewModel : ViewModel() {
    private var retrofitBuilder = RetrofitBuilder()

    private val _getInfoResponse = MutableLiveData<MyInfoResponse?>()
    val getInfoResponse: LiveData<MyInfoResponse?> = _getInfoResponse

    private val _getInfoError = MutableLiveData<String?>()
    val getInfoError: LiveData<String?> = _getInfoError


    suspend fun getUserInfoData(auth: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = retrofitBuilder.getUserInfo(auth)
                _getInfoResponse.postValue(response)
            } catch (e: Exception) {
                _getInfoError.postValue(e.message.toString())
            }
        }
    }
}
