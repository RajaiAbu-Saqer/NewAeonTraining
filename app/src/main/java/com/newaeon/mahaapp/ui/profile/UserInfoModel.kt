package com.newaeon.mahaapp.ui.profile

import com.google.gson.annotations.SerializedName


data class MyInfoResponse(

    @SerializedName("code") val code: Int,
    @SerializedName("data") val data: MyInfoData,
    @SerializedName("error") val error: Error
)

data class MyInfoData(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("mobileNumber") val mobileNumber: String,
    @SerializedName("businessName") val businessName: String,
    @SerializedName("email") val email: String,
    @SerializedName("site") val site: String,
    @SerializedName("image") val image: String,
    @SerializedName("businessType") val businessType: String,
    @SerializedName("isVerify") val isVerify: Boolean
)