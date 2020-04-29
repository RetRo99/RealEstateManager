package com.openclassrooms.realestatemanager.ui.map

import androidx.annotation.StringRes
import com.google.android.gms.maps.model.LatLng
import com.openclassrooms.realestatemanager.ui.map.model.UiMarkerModel

interface MapView {

    fun addMarker(marker: UiMarkerModel)
    fun getMapAsync()
    fun moveToLocation(latLng: LatLng)
    fun setMarkerClickListener()
    fun deleteAllMarkers()
    fun showToast(@StringRes stringResource: Int)

}
