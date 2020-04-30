package com.openclassrooms.realestatemanager.ui


interface MainView {

    fun fromListToDetails(id: Int)
    fun fromMapToDetails(id: Int)
    fun showToast(msg: String)
    fun navigateBack()

}
