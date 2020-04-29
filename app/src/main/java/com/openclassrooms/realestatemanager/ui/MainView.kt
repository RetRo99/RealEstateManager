package com.openclassrooms.realestatemanager.ui


interface MainView {

    fun fromListToDetails(id:String)
    fun fromMapToDetails(id: String)
    fun showToast(msg: String)

}
