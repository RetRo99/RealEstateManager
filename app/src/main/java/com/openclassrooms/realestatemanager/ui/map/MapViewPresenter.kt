package com.openclassrooms.realestatemanager.ui.map

interface MapViewPresenter {

    fun onViewCreated()
    fun onMapReady()
    fun onDestroy()
    fun onMarkerClicked(id: Int)

}
