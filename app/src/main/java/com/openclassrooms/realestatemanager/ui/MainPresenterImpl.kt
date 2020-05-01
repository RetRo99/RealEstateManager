package com.openclassrooms.realestatemanager.ui

import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainView
) : MainViewPresenter {


    override fun onMarkerClicked(id: Int) {
        view.fromMapToDetails(id)
    }

    override fun navigateBack() {
        view.navigateBack()
    }

    override fun fromSearchToResult(searchParams: PropertySearchParams) {
        view.fromSearchToResult(searchParams)
    }

    override fun fromSearchResultToDetails(id: Int) {
        view.fromSearchResultToDetails(id)
    }

    override fun onPropertyClicked(id: Int) {
        view.fromListToDetails(id)
    }
}
