package com.newaeon.mahaapp.ui.create_account

import com.google.gson.annotations.SerializedName

data class UserInfoModel(
    @SerializedName("fullname") var fullname: String,
    @SerializedName("email")   var email: String,
    @SerializedName("nationalID")  var nationalID: String,
    @SerializedName("phonenumber")  var phonenumber: String,
    @SerializedName("dataOfBirth")  var dataOfBirth: String,
    @SerializedName("password")   var password: String
)
