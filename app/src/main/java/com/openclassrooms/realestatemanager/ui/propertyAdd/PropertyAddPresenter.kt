package com.openclassrooms.realestatemanager.ui.propertyAdd

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail

interface PropertyAddPresenter {
    fun onAddProperty(property: UiPropertyDetail)
    fun onViewCreated(id: String?)
}
