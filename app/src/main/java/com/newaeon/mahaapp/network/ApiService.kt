package com.newaeon.mahaapp.network

import com.newaeon.mahaapp.ui.home.JokeResponse
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("jokes/random") // path for the server URL
    suspend fun getRandomJoke(@Header("User-Agent") key:String): JokeResponse


    @GET("jokes/random") // path for the server URL
    suspend fun getRandomJoke2(@Query("User-Agent") key:String): JokeResponse


    @POST("jokes/random") // path for the server URL
    suspend fun getRandomJoke3(@Body key:String): JokeResponse

}
