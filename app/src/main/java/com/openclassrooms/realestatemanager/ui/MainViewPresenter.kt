package com.openclassrooms.realestatemanager.ui

interface MainViewPresenter {

    fun onPropertyClicked(id: Int)
    fun onMarkerClicked(id: Int)
    fun navigateBack()
}
