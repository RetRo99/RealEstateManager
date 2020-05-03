package com.openclassrooms.realestatemanager.ui.photoFragment

import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem

interface PhotoFragmentPresenter {
    fun onViewCreated(photos: Array<UiPropertyDetailsPhotoItem>)
}
