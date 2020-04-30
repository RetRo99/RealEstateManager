package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty

interface PropertyRepository{

    fun getProperties(): List<UiProperty>
    fun addProperty(property: UiPropertyDetail)
    fun updateProperty(property: UiPropertyDetail)
    fun getProperty(id: String): UiPropertyDetail
}
