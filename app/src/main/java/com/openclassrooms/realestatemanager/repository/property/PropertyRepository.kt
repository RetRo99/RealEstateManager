package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail

interface PropertyRepository{

    fun getProperties(): List<UiPropertyDetail>
    fun addProperty(property: UiPropertyDetail)
    fun updateProperty(property: UiPropertyDetail)
}
