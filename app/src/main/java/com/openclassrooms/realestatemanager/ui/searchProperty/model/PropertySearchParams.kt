package com.openclassrooms.realestatemanager.ui.searchProperty.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PropertySearchParams(
    val type: String,
    val minSize: String,
    val maxSize: String,
    val interestPoints: List<String>,
    val fromDate: String,
    val toDate: String,
    val city: String,
    val minPhotos: Int,
    val priceMax: String,
    val priceMin: String,
    val showOnlySold:Boolean
) : Parcelable
