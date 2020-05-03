package com.openclassrooms.realestatemanager.ui.propertyDetails

import androidx.annotation.StringRes
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem

interface PropertyDetailsView {
    fun setItem(property: UiPropertyDetail)
    fun setPhotos(photos: List<UiPropertyDetailsPhotoItem>)
    fun showContent()
    fun showToast(@StringRes msg: Int)
}
