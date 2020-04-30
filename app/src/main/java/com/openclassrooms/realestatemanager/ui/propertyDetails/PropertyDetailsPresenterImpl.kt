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

    override fun onViewCreated(id: Int) {
        disposable = propertyRepository.getProperty(id)
            .subscribeBy(
                onSuccess = {
                    view.setItem(it)
                    if (it.photos.isNotEmpty()) view.setPhotos(it.photos)
                    view.showContent()
                }
            )
    }

    override fun onDestroy() {
        disposable?.dispose()
        val s:Int? = null
    }
}
