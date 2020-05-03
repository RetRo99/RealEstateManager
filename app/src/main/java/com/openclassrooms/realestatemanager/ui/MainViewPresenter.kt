package com.openclassrooms.realestatemanager.ui

import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams

interface MainViewPresenter {

    fun onPropertyClicked(id: Int)
    fun onMarkerClicked(id: Int)
    fun navigateBack()
    fun fromSearchToResult(searchParams: PropertySearchParams)
    fun fromSearchResultToDetails(id: Int)
    fun onCreate()
    fun onLoginSuccess()
    fun onLoginFailed()
    fun onLogout()
    fun onLogoutConfirmed()

}
