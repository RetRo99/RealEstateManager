package com.openclassrooms.realestatemanager.manager.property

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
import javax.inject.Inject

class PropertyManagerImpl @Inject constructor(
    private val propertyRepository: PropertyRepository
)
//    :PropertyManager {



//    override fun getProperties(): List<UiProperty> {
//        // TODO not implemented
//    }
//
//    override fun addProperty(property: UiPropertyDetail) {
//        // TODO not implemented
//    }
//
//    override fun updateProperty(property: UiPropertyDetail) {
//        propertyRepository.updateProperty()
//    }
//
//    override fun getProperty(id: String): UiPropertyDetail {
//        // TODO not implemented
//    }
//}
