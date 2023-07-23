package com.newaeon.mahaapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newaeon.mahaapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private val retrofitBuilder = RetrofitBuilder()
    val jokeLiveData = MutableLiveData<String>()


  suspend  fun fetchRandomJoke(key:String) {

        jokeLiveData.postValue("Mahaa Maliket android")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val jokeResponse = retrofitBuilder.getRandomJoke(key)
                jokeLiveData.postValue(jokeResponse.mahaResponse)
            } catch (e: Exception) {
                // Handle error here if needed
            }
        }
    }
}