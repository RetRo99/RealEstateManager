package com.openclassrooms.realestatemanager.ui.propertyDetails

import androidx.annotation.StringRes
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail

interface PropertyDetailsView {
    fun setItem(property: UiPropertyDetail)
    fun setPhotos(photos: List<String>)
    fun showContent()
    fun showToast(@StringRes msg: Int)
}
