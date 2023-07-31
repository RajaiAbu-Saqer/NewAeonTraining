package com.newaeon.mahaapp.ui.home

import com.google.gson.annotations.SerializedName

data class MyColorResponseModel(
    @SerializedName("10") val key10: Double?,
    @SerializedName("4") val key4: Double?,
    @SerializedName("2") val key2: Double?,
    @SerializedName("71") val key71: Double?,
    @SerializedName("5") val key5: Double?
)

data class MyColorRequestModel(
    @SerializedName("mahaKey1") val mahaKey1: Double?,
    @SerializedName("mahaKey2") val mahaKey2: Double?,
)

//{
//    imageUrl:"wjiefjweiffjgiowuggwe weui hewuh hfewufhew u"
//}
//
//{
//    "wjiefjweiffjgiowuggwe weui hewuh hfewufhew u"
//}

data class MyColorRequestModel2efew(
    @SerializedName("imageUrl") val imageUrl: String?,
)