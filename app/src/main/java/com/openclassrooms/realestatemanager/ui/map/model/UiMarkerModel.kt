package com.openclassrooms.realestatemanager.ui.map.model

import androidx.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng

data class UiMarkerModel(
    val latLng: LatLng,
    val title: String,
    val id: String,
    @DrawableRes val icon: Int
)
