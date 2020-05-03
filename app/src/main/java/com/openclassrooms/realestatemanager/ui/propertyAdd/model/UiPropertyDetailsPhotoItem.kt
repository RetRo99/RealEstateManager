package com.openclassrooms.realestatemanager.ui.propertyAdd.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class UiPropertyDetailsPhotoItem(val photo: String, val title: String) : Parcelable
