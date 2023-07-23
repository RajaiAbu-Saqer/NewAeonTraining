package com.newaeon.mahaapp.network

import com.newaeon.mahaapp.ui.home.JokeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with the actual API base URL  // base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
    suspend fun getRandomJoke(key:String):JokeResponse= apiService.getRandomJoke(key)

}