package com.openclassrooms.realestatemanager.ui.searchResult

import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams

interface SearchResultPresenter {
    fun onViewCreated(searchParams: PropertySearchParams)
    fun onDestroy()
    fun onProperyClicked(id: Int)
}
