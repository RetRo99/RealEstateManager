package com.openclassrooms.realestatemanager.ui

import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams


interface MainView {

    fun fromListToDetails(id: Int)
    fun fromMapToDetails(id: Int)
    fun showToast(msg: String)
    fun navigateBack()
    fun fromSearchToResult(searchParams: PropertySearchParams)
    fun fromSearchResultToDetails(id: Int)
    fun setupScreen()
    fun requestLogin()
    fun showLogOutDialog()

}
