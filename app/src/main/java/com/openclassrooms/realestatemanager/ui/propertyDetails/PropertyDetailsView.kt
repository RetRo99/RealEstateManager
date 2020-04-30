package com.openclassrooms.realestatemanager.ui.propertyDetails

import android.net.Uri
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail

interface PropertyDetailsView {
    fun setItem(property: UiPropertyDetail)
    fun setPhotos(photos: List<Uri>)
}
