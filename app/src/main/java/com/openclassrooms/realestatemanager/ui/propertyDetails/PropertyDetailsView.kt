package com.openclassrooms.realestatemanager.ui.propertyDetails

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail

interface PropertyDetailsView {
    fun setItem(property: UiPropertyDetail)
    fun setPhotos(photos: List<String>)
}
