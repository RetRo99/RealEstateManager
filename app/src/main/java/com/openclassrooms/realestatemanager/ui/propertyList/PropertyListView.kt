package com.openclassrooms.realestatemanager.ui.propertyList

import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty

interface PropertyListView {
    fun setData(data: List<UiProperty>)
}
