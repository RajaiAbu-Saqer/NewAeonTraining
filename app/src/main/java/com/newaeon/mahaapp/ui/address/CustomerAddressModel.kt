package com.newaeon.mahaapp.ui.address


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.newaeon.mahaapp.BaseError
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomerAddressResponse(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: ArrayList<GetCustomerAddressesData>?,
    @SerializedName("error") val error: BaseError?
) : Parcelable


@Parcelize
data class GetCustomerAddressesData(

    @SerializedName("addressId") val addressId: Int?,
    @SerializedName("city") val city: String?,
    @SerializedName("address1") val address1: String?,
    @SerializedName("address2") val address2: String?,
    @SerializedName("longitude") val longitude: String?,
    @SerializedName("latitude") val latitude: String?
) : Parcelable


data class BooleanDataResponse(

    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: Boolean?,
    @SerializedName("error") val error: BaseError?
)


data class AddCustomerAddressRequest(


    val city: String?,
    val address1: String?,
    val address2: String?,
    val longitude: String?,
    val latitude: String?,
    val contactPersonName: String?,
    val contactPersonPhone: String?,
    var id: Int?

)

data class DeleteCustomerAddressRequest(
    val addressId: Int
)

