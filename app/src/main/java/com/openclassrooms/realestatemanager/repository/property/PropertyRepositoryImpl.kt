package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty

class PropertyRepositoryImpl:PropertyRepository {

    val itemList = mutableListOf(
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma"),
        UiProperty("123", "sex house", "zasotnj", "pr men Doma")
    )

    val details = mutableListOf<UiPropertyDetail>()

    override fun getProperty(id: String): UiPropertyDetail {
       return details.find {
           it.id == id
       } ?: throw Exception("Property that wants to be edited has to here")
    }

    override fun updateProperty(property: UiPropertyDetail) {

    }

    override fun getProperties(): List<UiProperty> {
        return itemList
    }

    override fun addProperty(property: UiPropertyDetail) {
        details.add(property)
        itemList.add(
            UiProperty(
                property.id,
                property.type,
                property.price.toString(),
                property.address.city
            )
        )
    }


}
