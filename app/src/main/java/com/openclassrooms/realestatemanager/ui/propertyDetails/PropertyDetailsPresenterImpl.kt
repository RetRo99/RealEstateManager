package com.openclassrooms.realestatemanager.ui.propertyDetails

import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.utils.Utils
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PropertyDetailsPresenterImpl @Inject constructor(
    private val view: PropertyDetailsView,
    private val propertyRepository: PropertyRepository

) : PropertyDetailsPresenter {

    private var disposable: Disposable? = null
    private var updateDisposable: Disposable? = null

    private lateinit var property: UiPropertyDetail
    private var id = 0

    override fun onViewCreated(id: Int) {
        this.id = id
        getProperty()
    }

    override fun onDestroy() {
        disposable?.dispose()
        updateDisposable?.dispose()
    }

    override fun onMarkSoldClicked() {
        updateDisposable = propertyRepository.updateProperty(
            property.copy(
                isSold = true,
                soldDate = Utils.todayDate
            )
        )
            .subscribeBy(
                onComplete = {
                    getProperty()
                },
                onError = {
                    view.showToast(R.string.error_something_wrong)
                }
            )
    }

    private fun getProperty() {
        disposable?.dispose()
        disposable = propertyRepository.getProperty(id)
            .subscribeBy(
                onSuccess = {
                    this.property = it
                    view.setItem(it)
                    if (it.photos.isNotEmpty()) view.setPhotos(it.photos)
                    view.showContent()
                }
            )
    }
}
