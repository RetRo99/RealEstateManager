package com.openclassrooms.realestatemanager.ui.propertyDetails

interface PropertyDetailsPresenter {
     fun onViewCreated(id: Int)
    fun onDestroy()
    fun onMarkSoldClicked()
    fun onPhotoClicked()
}
