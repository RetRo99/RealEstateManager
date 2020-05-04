package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.util.Log
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.manager.notificationManager.NotificationHelper
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import com.openclassrooms.realestatemanager.utils.PropertyFormatter
import com.vansuita.pickimage.bean.PickResult
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PropertyAddPresenterImpl @Inject constructor(
    private val view: PropertyAddView,
    private val propertyRepository: PropertyRepository,
    private val parentPresenter: MainViewPresenter,
    private val propertyFormatter : PropertyFormatter,
    private val notificationHelper:NotificationHelper

):PropertyAddPresenter {

    private var isEdit = false

    //handle rotate
    private var photos = mutableListOf<UiPropertyDetailsPhotoItem>()
    private val compositeDisposable = CompositeDisposable()
    private var currentId = 0
    private lateinit var property: UiPropertyDetail
    private var isSold = false
    private var soldDate = ""

    override fun onAddProperty(property: UiPropertyDetail) {
        this.property = propertyFormatter.format(property)
        if (isEdit) updateProperty() else addProperty()
    }

    private fun updateProperty() {
        notificationHelper.createUpdatedNotification(currentId)
        propertyRepository.updateProperty(property.copy(photos = photos, id = currentId, isSold = isSold, soldDate = soldDate))
            .subscribeBy(
                onError = {
                    view.showToast(R.string.error_something_wrong_address)

                },
                onComplete = {
                    parentPresenter.navigateBack()
                }
            ).addTo(compositeDisposable)
    }

    private fun addProperty() {
        notificationHelper.createAddedNotification(currentId)
        propertyRepository.addProperty(
            property.copy(
                photos = photos
            )
        ).subscribeBy(
            onComplete = {
                parentPresenter.navigateBack()
            },
            onError = {
                Log.d("čič", "onError")
                it.printStackTrace()
                view.showToast(R.string.error_something_wrong)
            }
        ).addTo(compositeDisposable)
    }

    override fun onViewCreated(id: Int) {
        if (id != 0){
            isEdit = true
            currentId = id
            propertyRepository.getProperty(id)
                .subscribeBy(
                    onSuccess = {
                        isSold = it.isSold
                        soldDate = it.soldDate
                        view.setItem(it)
                        photos.addAll(it.photos)
                        view.setPhotos(photos)
                    },
                    onError = {
                        it.printStackTrace()
                    }
                ).addTo(compositeDisposable)
        }
        view.showContent()
    }

    override fun onAddPropertyClicked() {
        view.clearErrors()
        view.validateData()
    }

    override fun onAddPhotoClicked() {
        view.showImageDialog()
    }

    override fun onRemovePhotoClicked(position: Int) {
        photos.removeAt(position)
        view.setPhotos(photos)
    }

    override fun onImagePicked(
        result: PickResult?,
        title: String
    ) {
        if (result != null) {
            photos.add(UiPropertyDetailsPhotoItem(result.path, title))
            view.setPhotos(photos)
        }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}
