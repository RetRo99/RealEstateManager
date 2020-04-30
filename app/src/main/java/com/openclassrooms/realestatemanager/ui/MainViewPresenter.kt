package com.openclassrooms.realestatemanager.ui

interface MainViewPresenter {

    fun onPropertyClicked(id: String)
    fun onMarkerClicked(id: String)
    fun navigateBack()
}
