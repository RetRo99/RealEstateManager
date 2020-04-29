package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty

interface PropertyRepository{

    fun getProperties(): List<UiProperty>
}
