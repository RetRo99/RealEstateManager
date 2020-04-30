package com.openclassrooms.realestatemanager.ui.propertyList

interface PropertyListPresenter {
    fun onViewCreated()
    fun onProperyClicked(id: String)
    fun onDestroy()
}
