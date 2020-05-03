package com.openclassrooms.realestatemanager.ui

import com.openclassrooms.realestatemanager.manager.auth.FirebaseAuthManager
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainView,
    private val auth: FirebaseAuthManager
) : MainViewPresenter {


    override fun onMarkerClicked(id: Int) {
        view.fromMapToDetails(id)
    }

    override fun navigateBack() {
        view.navigateBack()
    }

    override fun onLoginSuccess() {
        view.setupScreen()
    }

    override fun onLoginFailed() {
        view.requestLogin()
    }

    override fun onLogout() {
        view.showLogOutDialog()
    }

    override fun onLogoutConfirmed() {
        auth.logoutUser()
        view.requestLogin()
    }

    override fun onCreate() {
        if (auth.isUserLogged()) view.setupScreen() else view.requestLogin()
    }

    override fun fromDetailsToPhoto(photos: Array<UiPropertyDetailsPhotoItem>) {
        view.fromDetailsToPhotos(photos)
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
