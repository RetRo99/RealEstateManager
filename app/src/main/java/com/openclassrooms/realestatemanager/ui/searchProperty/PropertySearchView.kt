package com.openclassrooms.realestatemanager.ui.searchProperty

import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams

interface PropertySearchView {
    fun getSearchParams():PropertySearchParams
}
