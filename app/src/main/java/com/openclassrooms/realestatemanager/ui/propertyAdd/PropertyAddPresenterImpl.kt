package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.net.Uri
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.vansuita.pickimage.bean.PickResult
import java.util.*
import javax.inject.Inject

class PropertyAddPresenterImpl @Inject constructor(
    private val view: PropertyAddView,
    private val propertyRepository: PropertyRepository

):PropertyAddPresenter {

    private var isEdit = false
    private var photos = mutableListOf<Uri>()

    override fun onAddProperty(property: UiPropertyDetail) {
        if (isEdit) {
            propertyRepository.updateProperty(property.copy(photos = photos))
        } else {
            propertyRepository.addProperty(
                property.copy(
                    id = UUID.randomUUID().toString(),
                    photos = photos
                )
            )

        }
    }

    override fun onViewCreated(id: String?) {
        id?.let {
            isEdit = true
            val property = propertyRepository.getProperty(it)
            view.setItem(property)
            photos.addAll(property.photos)
            view.setPhotos(photos)
        }
    }

    override fun onAddPropertyClicked() {
        view.clearErrors()
        view.checkIfFilled()
    }

    override fun onAddPhotoClicked() {
        view.showImageDialog()
    }

    override fun onRemovePhotoClicked(position: Int) {
        photos.removeAt(position)
        view.setPhotos(photos)
    }

    override fun onImagePicked(result: PickResult?) {
        if (result != null) {
            photos.add(result.uri)
            view.setPhotos(photos)
        }
    }
}
