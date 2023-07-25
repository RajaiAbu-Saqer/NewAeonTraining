package com.newaeon.mahaapp.ui.notifications

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NotificationModel(
    val title: String,
    val firstDescription: String,
    val secondDescription: String
) : Parcelable