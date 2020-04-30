package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.util.Log
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import com.vansuita.pickimage.bean.PickResult
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PropertyAddPresenterImpl @Inject constructor(
    private val view: PropertyAddView,
    private val propertyRepository: PropertyRepository,
    private val parentPresenter: MainViewPresenter

):PropertyAddPresenter {

    private var isEdit = false
    private var photos = mutableListOf<String>()
    private val compositeDisposable = CompositeDisposable()
    private var currentId = 0

    override fun onAddProperty(property: UiPropertyDetail) {
        if (isEdit) {
            propertyRepository.updateProperty(property.copy(photos = photos, id = currentId))
                .subscribeBy(
                    onError = {
                        view.showToast(R.string.error_something_wrong)

                    },
                    onComplete = {
                        parentPresenter.navigateBack()
                    }
                ).addTo(compositeDisposable)
        } else {
            propertyRepository.addProperty(
                property.copy(
                    photos = photos
                )
            ).subscribeBy(
                onComplete = {
                    parentPresenter.navigateBack()
                },
                onError = {
                    view.showToast(R.string.error_something_wrong)
                }
            ).addTo(compositeDisposable)

        }
    }

    override fun onViewCreated(id: Int) {
        if (id != 0){
            isEdit = true
            currentId = id
            propertyRepository.getProperty(id)
                .subscribeBy(
                    onSuccess = {
                        Log.d("čič", "onSuccess")
                        view.setItem(it)
                        photos.addAll(it.photos)
                        view.setPhotos(photos)
                    },
                    onError = {
                        Log.d("čič", "onError")
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

    override fun onImagePicked(result: PickResult?) {
        if (result != null) {
            photos.add(result.path)
            view.setPhotos(photos)
        }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}
