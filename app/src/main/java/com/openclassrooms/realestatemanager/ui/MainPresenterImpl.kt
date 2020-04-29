package com.openclassrooms.realestatemanager.ui

import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainView
) : MainViewPresenter {

    private lateinit var currentId: String

    override fun onMarkerClicked(id: String) {
        currentId = id
        view.fromMapToDetails(id)
    }

    override fun onPropertyClicked(id: String) {
        currentId = id
        view.fromListToDetails(id)
    }
}
