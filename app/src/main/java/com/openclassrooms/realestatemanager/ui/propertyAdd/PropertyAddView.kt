package com.openclassrooms.realestatemanager.ui.propertyAdd

import androidx.annotation.StringRes
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem

interface PropertyAddView {
    fun setItem(property: UiPropertyDetail)
    fun clearErrors()
    fun validateData()
    fun showImageDialog()
    fun setPhotos(photos: MutableList<UiPropertyDetailsPhotoItem>)
    fun showToast(@StringRes msg: Int)
    fun showContent()
}
