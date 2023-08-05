package com.newaeon.mahaapp.ui.address

import com.google.gson.annotations.SerializedName
import com.newaeon.mahaapp.BaseError

data class CustomerAddressResponse (
    @SerializedName("code") val code: Int,
    @SerializedName("data") val data: List<GetCustomerAddressesData>,
    @SerializedName("error") val error: BaseError
)


data class GetCustomerAddressesData(

    @SerializedName("addressId") val addressId: Int,
    @SerializedName("city") val city: String,
    @SerializedName("address1") val address1: String,
    @SerializedName("address2") val address2: String,
    @SerializedName("longitude") val longitude: String,
    @SerializedName("latitude") val latitude: String
)



