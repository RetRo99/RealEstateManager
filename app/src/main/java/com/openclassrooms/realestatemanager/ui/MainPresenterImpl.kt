package com.openclassrooms.realestatemanager.ui

import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainView
) : MainViewPresenter {
    override fun onMarkerClicked(id: String) {
        view.fromMapToDetails(id)
    }

    override fun onPropertyClicked(id: String) {
        view.fromListToDetails(id)
    }


}
