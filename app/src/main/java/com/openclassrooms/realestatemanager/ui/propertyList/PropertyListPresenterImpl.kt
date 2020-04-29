package com.openclassrooms.realestatemanager.ui.propertyList

import com.openclassrooms.realestatemanager.ui.propertyList.model.DummyContent
import javax.inject.Inject

class PropertyListPresenterImpl @Inject constructor(
    private val view: PropertyListView ): PropertyListPresenter {

    override fun onViewCreated() {

        view.setData(DummyContent.ITEMS)
    }

}
