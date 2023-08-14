package com.newaeon.mahaapp.ui.registration.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.BaseError
import com.newaeon.mahaapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {

    private val retrofitBuilder = RetrofitBuilder()


    private val _registrationResponse = MutableLiveData<RegistrationData?>()
    val registrationResponse: LiveData<RegistrationData?> = _registrationResponse


    private val _signupResponeError = MutableLiveData<BaseError?>()
    val signupResponeError: LiveData<BaseError?> = _signupResponeError

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress


    suspend fun callSignupApi(registrationRequestModel: RegistrationRequestModel?) {
        _showProgress.postValue(true)

//        var response: RegistrationResponseModel? = null
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                response = retrofitBuilder.registratonUser(registrationRequestModel)
//                _registrationResponse.postValue(response?.data)
//            } catch (e: Exception) {
//                _signupResponeError.postValue(response?.error)
//                // Handle error here if needed
//            }
//        }
        viewModelScope.launch(Dispatchers.IO) {
            retrofitBuilder.registratonUser(registrationRequestModel).apply {
                try {
                    _registrationResponse.postValue(data)
                } catch (e: Exception) {
                    _signupResponeError.postValue(error)
                }
                finally { // finally execute after try and catch "always executed"
                    _showProgress.postValue(false)
                }
            }


        }
    }


}