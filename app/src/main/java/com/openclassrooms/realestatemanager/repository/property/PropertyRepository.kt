package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.ui.propertyList.model.DummyContent

interface PropertyRepository{

    fun getProperties():List<DummyContent.DummyItem>
}
