package com.openclassrooms.realestatemanager.ui.propertyList

import com.openclassrooms.realestatemanager.ui.propertyList.model.DummyContent

interface PropertyListView {
    fun setData(data: List<DummyContent.DummyItem>)
}
