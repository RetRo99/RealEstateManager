package com.openclassrooms.realestatemanager.ui.propertyList

interface PropertyListPresenter {
    fun onViewCreated()
    fun onProperyClicked(id: Int)
    fun onDestroy()
}
