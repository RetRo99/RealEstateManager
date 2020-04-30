package com.openclassrooms.realestatemanager.ui.propertyDetails

import android.util.Log
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import javax.inject.Inject

class PropertyDetailsPresenterImpl @Inject constructor(
    private val view: PropertyDetailsView,
    private val propertyRepository: PropertyRepository

) : PropertyDetailsPresenter {


    override fun onViewCreated(id: String) {
        propertyRepository.getProperty(id)
    }

}
