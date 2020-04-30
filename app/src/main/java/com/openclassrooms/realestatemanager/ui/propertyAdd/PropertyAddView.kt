package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.net.Uri
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail

interface PropertyAddView {
    fun setItem(property: UiPropertyDetail)
    fun clearErrors()
    fun checkIfFilled()
    fun showImageDialog()
    fun setPhotos(photos: List<Uri>)
}
