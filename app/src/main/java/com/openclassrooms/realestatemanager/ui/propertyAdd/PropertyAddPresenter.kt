package com.openclassrooms.realestatemanager.ui.propertyAdd

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.vansuita.pickimage.bean.PickResult

interface PropertyAddPresenter {
    fun onAddProperty(property: UiPropertyDetail)
    fun onViewCreated(id: Int)
    fun onAddPropertyClicked()
    fun onAddPhotoClicked()
    fun onImagePicked(result: PickResult?, title: String)
    fun onRemovePhotoClicked(position: Int)
    fun onDestroy()
}
