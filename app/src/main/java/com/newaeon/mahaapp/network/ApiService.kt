package com.newaeon.mahaapp.network

import com.newaeon.mahaapp.ui.address.AddCustomerAddressRequest
import com.newaeon.mahaapp.ui.address.BooleanDataResponse
import com.newaeon.mahaapp.ui.address.CustomerAddressResponse
import com.newaeon.mahaapp.ui.address.DeleteCustomerAddressRequest
import com.newaeon.mahaapp.ui.home.JokeResponse
import com.newaeon.mahaapp.ui.home.MyColorResponseModel
import com.newaeon.mahaapp.ui.home.Person
import com.newaeon.mahaapp.ui.logout.LogoutRequestModel
import com.newaeon.mahaapp.ui.orders.GetMyOrdersResponse
import com.newaeon.mahaapp.ui.product.GetAllProductsResponse
import com.newaeon.mahaapp.ui.profile.MyInfoResponse
import com.newaeon.mahaapp.ui.profile.UpdateMyInfoRequest
import com.newaeon.mahaapp.ui.profile.UpdateMyInfoResponse
import com.newaeon.mahaapp.ui.registration.signin.LoginRequest
import com.newaeon.mahaapp.ui.registration.signin.LoginResponse
import com.newaeon.mahaapp.ui.registration.signup.RegistrationRequestModel
import com.newaeon.mahaapp.ui.registration.signup.RegistrationResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("jokes/random") // path for the server URL
    suspend fun getRandomJoke(@Header("User-Agent") key: String): JokeResponse


    @GET("jokes/random") // path for the server URL
    suspend fun getRandomJoke2(@Query("User-Agent") key: String): JokeResponse


    @POST("jokes/random") // path for the server URL
    suspend fun getRandomJoke3(@Body key: String): JokeResponse


    @GET("Admin/Items") // path for the server URL
    suspend fun getRandomJoke222(
        @Query("pageNumber") pageNumber: Int,
        @Query("recordsPerPage") recordsPerPage: Int
    ): Person


    @POST("dominantColor")
    fun setColor(
        @Query("imageURL") imageUrl: String,
        @Header("Authorization") authorization: String,
        @Body myColorRequestModel: String
    ): MyColorResponseModel


    @GET("api/Products/GetAll")
    suspend fun allProducts(): GetAllProductsResponse


    @POST("api/Customers/Login")
    suspend fun login(@Body loginRequest: LoginRequest?): LoginResponse

    @POST("api/Customers/Register")
    suspend fun registration(
        @Body registrationRequestModel: RegistrationRequestModel?
    ): RegistrationResponseModel

//    @Header("Authorization") auth: String,

    @GET("api/Addresses/GetCustomerAddresses")
    suspend fun getCustomerAddresses(@Header("Authorization") auth: String): CustomerAddressResponse


    @POST("api/Addresses/DeleteCustomerAddress")
    suspend fun deleteCustomerAddress(
        @Header("Authorization") auth: String,
        @Body deleteCustomerAddressRequest: DeleteCustomerAddressRequest?
    ): BooleanDataResponse

    @POST("api/Addresses/UpdateCustomerAddress")
    suspend fun updateAddress(
        @Body addCustomerAddressRequest: AddCustomerAddressRequest,
        @Header("Authorization") auth: String
    ): BooleanDataResponse

    @GET("api/Orders/GetMyOrders")
    suspend fun getMyOrders(
        @Header("Authorization") auth: String
    ): GetMyOrdersResponse



    @POST("api/Customers/Logout")
  suspend fun logout
                (@Body logoutRequestModel: LogoutRequestModel?,
                 @Header("Authorization") auth: String
    ): BooleanDataResponse

    @GET("api/Customers/GetMyInfo")
    suspend fun getMyInfo(
        @Header("Authorization") auth: String
    ): MyInfoResponse


    @POST("api/Customers/UpdateMyInfo")
    suspend fun updateMyInfo(
        @Body updateMyInfoRequest: UpdateMyInfoRequest,
        @Header("Authorization") auth: String
    ): UpdateMyInfoResponse
}

// 401 unauthorized token failed
// 400 Bad request
// 500 internal server error
// 404 Not found
// 200 successfully