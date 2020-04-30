package com.openclassrooms.realestatemanager.ui.propertyAdd

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import java.util.*
import javax.inject.Inject

class PropertyAddPresenterImpl @Inject constructor(
    private val view: PropertyAddView,
    private val propertyRepository: PropertyRepository

):PropertyAddPresenter {

    private var isEdit = false

    override fun onAddProperty(property: UiPropertyDetail) {
        if (isEdit) {
            propertyRepository.updateProperty(property)
        } else {
            propertyRepository.addProperty(property.copy(id = UUID.randomUUID().toString()))

        }
    }

    override fun onViewCreated(id: String?) {
        id?.let {
            isEdit = true
            view.setItem(propertyRepository.getProperty(it))
        }
    }
}
