package com.openclassrooms.realestatemanager.ui.propertyList

import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import javax.inject.Inject

class PropertyListPresenterImpl @Inject constructor(
    private val view: PropertyListView,
    private val propertyRepository: PropertyRepository,
    private val parentPresenter: MainViewPresenter

): PropertyListPresenter {

    override fun onViewCreated() {
        view.setData(propertyRepository.getProperties())
    }

    override fun onProperyClicked(id:String){
        parentPresenter.onPropertyClicked(id)
    }

}
