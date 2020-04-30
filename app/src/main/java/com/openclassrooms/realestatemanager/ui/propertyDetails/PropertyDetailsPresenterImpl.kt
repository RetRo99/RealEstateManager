package com.openclassrooms.realestatemanager.ui.propertyDetails

import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PropertyDetailsPresenterImpl @Inject constructor(
    private val view: PropertyDetailsView,
    private val propertyRepository: PropertyRepository

) : PropertyDetailsPresenter {

    private var disposable: Disposable? = null

    override fun onViewCreated(id: String) {
        disposable = propertyRepository.getProperty(id)
            .subscribeBy(
                onSuccess = {
                    view.setItem(it)
                    view.setPhotos(it.photos)
                }
            )
    }

    override fun onDestroy() {
        disposable?.dispose()

    }

}
