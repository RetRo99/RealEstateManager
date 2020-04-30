package com.openclassrooms.realestatemanager.ui.map.model

import com.google.android.gms.maps.model.LatLng

data class UiMarkerModel(
    val latLng: LatLng,
    val id: String
)
