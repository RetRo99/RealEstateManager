package com.openclassrooms.realestatemanager.ui.searchResult

import android.util.Log
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainView
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class SearchResultPresenterImpl @Inject constructor(
    private val view: SearchResultView,
    private val propertyRepository: PropertyRepository,
    private val parentPresenter: MainViewPresenter

):SearchResultPresenter {

    private var searchDisposable: Disposable? = null

    override fun onViewCreated(searchParams: PropertySearchParams) {
        searchDisposable = propertyRepository.getSearchProperties(searchParams)
            .map {
                it.map {
                    UiProperty(it.id, it.type, it.price.toString(), it.address.city, it.photos[0].photo)
                }
            }
            .subscribeBy(
                onNext = {
                    if (it.isNotEmpty()) view.setData(it) else view.showToast(R.string.error_no_results)
                },
                onError = {
                    Log.d("čič", "onError")
                    it.printStackTrace()
                    view.showToast(R.string.error_no_results)
                }
            )
    }

    override fun onProperyClicked(id: Int) {
        parentPresenter.fromSearchResultToDetails(id)
    }

    override fun onDestroy() {
        // TODO not implemented
    }
}
