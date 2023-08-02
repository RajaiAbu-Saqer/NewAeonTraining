package com.newaeon.mahaapp

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseError(

    @SerializedName("errors") val errors: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("detail") val detail: String?,
    @SerializedName("innerException") val innerException: String?
) : Parcelable