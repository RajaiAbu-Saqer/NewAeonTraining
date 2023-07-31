package com.newaeon.mahaapp.ui.home

import com.google.gson.annotations.SerializedName

data class JokeResponse(val mahaResponse: String)


data class Person(
    @SerializedName("name") val name: String?,
    @SerializedName("age") val age: Int?,
    @SerializedName("car") val car: String? // Assuming "car" is of type String, change it accordingly if it's a different type
)