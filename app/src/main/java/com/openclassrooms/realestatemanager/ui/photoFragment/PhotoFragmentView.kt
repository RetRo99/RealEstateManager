package com.openclassrooms.realestatemanager.ui.photoFragment

import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem

interface PhotoFragmentView {
    fun setPhotos(photos: Array<UiPropertyDetailsPhotoItem>)
}
