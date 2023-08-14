package com.newaeon.mahaapp.network

import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import com.newaeon.mahaapp.ui.address.DeleteCustomerAddressRequest
import com.newaeon.mahaapp.ui.home.JokeResponse
import com.newaeon.mahaapp.ui.logout.LogoutRequestModel
import com.newaeon.mahaapp.ui.profile.UpdateMyInfoRequest
import com.newaeon.mahaapp.ui.registration.signin.LoginRequest
import com.newaeon.mahaapp.ui.registration.signup.RegistrationRequestModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header


class RetrofitBuilder {
    private val apiService: ApiService by lazy {
//        val client = OkHttpClient.Builder() // add our curl logger here
//            .addInterceptor(CurlLoggerInterceptor())
        val retrofit = Retrofit.Builder()
            .baseUrl("http://40.115.6.93:4525/") // Replace with the actual API base URL  // base URL
//            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

    suspend fun getRandomJoke(key: String): JokeResponse = apiService.getRandomJoke(key)
    suspend fun getRandomJoke222(pageNumber: Int, recordsPerPage: Int) =
        apiService.getRandomJoke222(pageNumber, recordsPerPage)

    suspend fun getAllProduct() = apiService.allProducts()

    suspend fun loginUser(loginRequest: LoginRequest?) = apiService.login(loginRequest)
    suspend fun registratonUser(registrationRequestModel: RegistrationRequestModel?) =
        apiService.registration(registrationRequestModel)


    suspend fun getUserAddresses(auth: String) = apiService.getCustomerAddresses(auth)

    suspend fun editUSerAddress(
        addCustomerAddressRequest: AddCustomerAddressRequest,
        auth: String
    ) =
        apiService.updateAddress(addCustomerAddressRequest, auth)

    suspend fun deleteCustomerAddress(
        deleteCustomerAddressRequest: DeleteCustomerAddressRequest,
        auth: String
    ) =
        apiService.deleteCustomerAddress(auth, deleteCustomerAddressRequest)

    suspend fun getOrders(auth: String) = apiService.getMyOrders(auth)

    suspend fun logoutUser(logoutRequestModel: LogoutRequestModel , auth: String) = apiService.logout(logoutRequestModel, auth)

    suspend fun getUserInfo(auth: String) = apiService.getMyInfo(auth)

    suspend fun updateInfo(updateMyInfoRequest:UpdateMyInfoRequest, auth:String)=apiService.updateMyInfo(updateMyInfoRequest,auth)
}