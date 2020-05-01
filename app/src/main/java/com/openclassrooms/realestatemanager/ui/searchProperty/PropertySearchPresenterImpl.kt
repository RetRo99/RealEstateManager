package com.openclassrooms.realestatemanager.ui.searchProperty

import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import javax.inject.Inject

class PropertySearchPresenterImpl @Inject constructor(
    private val view: PropertySearchView,
    private val parentPresenter:MainViewPresenter

) : PropertySearchPresenter {

    override fun onSearchClicked() {
        parentPresenter.fromSearchToResult(view.getSearchParams())
    }
}
