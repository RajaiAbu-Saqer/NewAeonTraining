package com.newaeon.mahaapp.network

import com.newaeon.mahaapp.ui.home.JokeResponse
import com.newaeon.mahaapp.ui.home.MyColorResponseModel
import com.newaeon.mahaapp.ui.product.GetAllProductsResponse
import com.newaeon.mahaapp.ui.registration.signin.LoginRequest
import com.newaeon.mahaapp.ui.registration.signup.RegistrationRequestModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://40.115.6.93:4525/") // Replace with the actual API base URL  // base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

    suspend fun getRandomJoke(key: String): JokeResponse = apiService.getRandomJoke(key)
    suspend fun getRandomJoke222(pageNumber: Int, recordsPerPage: Int) =
        apiService.getRandomJoke222(pageNumber, recordsPerPage)

    suspend fun getAllProduct()=apiService.allProducts()

    suspend fun loginUser(loginRequest: LoginRequest?)=apiService.login(loginRequest)
    suspend fun registratonUser(registrationRequestModel: RegistrationRequestModel?)=apiService.registration(registrationRequestModel)


}