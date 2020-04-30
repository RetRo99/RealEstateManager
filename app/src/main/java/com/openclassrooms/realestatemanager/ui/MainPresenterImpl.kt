package com.openclassrooms.realestatemanager.ui

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

    override fun onPropertyClicked(id: Int) {
        view.fromListToDetails(id)
    }
}
