package com.newaeon.mahaapp.network

import com.newaeon.mahaapp.ui.home.JokeResponse
import com.newaeon.mahaapp.ui.home.MyColorResponseModel
import com.newaeon.mahaapp.ui.home.Person
import com.newaeon.mahaapp.ui.product.GetAllProductsResponse
import com.newaeon.mahaapp.ui.registration.signin.LoginRequest
import com.newaeon.mahaapp.ui.registration.signin.LoginResponse
import com.newaeon.mahaapp.ui.registration.signup.RegistrationRequestModel
import com.newaeon.mahaapp.ui.registration.signup.RegistrationResponseModel
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

    @POST("/api/Customers/Register")
    suspend fun registration(
        @Body registrationRequestModel: RegistrationRequestModel?
    ): RegistrationResponseModel

//    @Header("Authorization") auth: String,
}
