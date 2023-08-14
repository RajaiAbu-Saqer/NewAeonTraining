package com.newaeon.mahaapp.ui.logout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.BaseError
import com.newaeon.mahaapp.network.RetrofitBuilder
import com.newaeon.mahaapp.ui.registration.signin.LoginData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogoutViewModel : ViewModel() {
    private var retrofitBuilder = RetrofitBuilder()

    private val _logoutResponse = MutableLiveData<Boolean?>()
    var logoutResponse: LiveData<Boolean?> = _logoutResponse

    private val _logoutError = MutableLiveData<String?>()
    val logoutError: LiveData<String?> = _logoutError


    suspend fun logoutUser(logoutRequestModel: LogoutRequestModel , auth: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = retrofitBuilder.logoutUser(logoutRequestModel , auth)
                if (response.data == true) {
                    _logoutResponse.postValue(true)
                } else {
                    _logoutError.postValue("Error : $response")
                }
            } catch (e: Exception) {
                _logoutError.postValue("An Error occrred : ${e.message}")
            }
        }
    }
}
