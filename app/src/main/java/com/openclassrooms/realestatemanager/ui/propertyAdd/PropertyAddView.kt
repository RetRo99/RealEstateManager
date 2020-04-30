package com.openclassrooms.realestatemanager.ui.propertyAdd

import androidx.annotation.StringRes
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail

interface PropertyAddView {
    fun setItem(property: UiPropertyDetail)
    fun clearErrors()
    fun checkIfFilled()
    fun showImageDialog()
    fun setPhotos(photos: List<String>)
    fun showToast(@StringRes msg: Int)

}
