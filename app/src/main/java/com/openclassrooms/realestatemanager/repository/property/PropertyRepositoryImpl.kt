package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.ui.propertyList.model.DummyContent

class PropertyRepositoryImpl:PropertyRepository{


    override fun getProperties(): List<DummyContent.DummyItem> {
        return DummyContent.ITEMS
    }


}
