package com.openclassrooms.realestatemanager.ui.photoFragment

import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import javax.inject.Inject

class PhotoFragmentPresenterImpl @Inject constructor(
private val view:PhotoFragmentView
) : PhotoFragmentPresenter {


    override fun onViewCreated(photos: Array<UiPropertyDetailsPhotoItem>) {
        view.setPhotos(photos)
    }
}
