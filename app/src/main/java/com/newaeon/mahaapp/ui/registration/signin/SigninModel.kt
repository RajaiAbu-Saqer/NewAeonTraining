package com.newaeon.mahaapp.ui.registration.signin

import com.google.gson.annotations.SerializedName
import com.newaeon.mahaapp.BaseError

data class LoginRequest(

    @SerializedName("mobileNumber") val mobileNumber: String,
    @SerializedName("password") val password: String,
    @SerializedName("notificationKey") var notificationKey: String? = ""
)


data class LoginResponse(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: LoginData?,
    @SerializedName("error") val baseError: BaseError?
)

data class LoginData(

    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("phoneNumber") val phoneNumber: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("token") val token: String?
)
