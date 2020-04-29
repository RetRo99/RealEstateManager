package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty

class PropertyRepositoryImpl:PropertyRepository{


    override fun getProperties(): List<UiProperty> {
        return listOf(
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
    }


}
