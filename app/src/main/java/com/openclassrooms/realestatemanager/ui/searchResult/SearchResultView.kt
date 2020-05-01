package com.openclassrooms.realestatemanager.ui.searchResult

import androidx.annotation.StringRes
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty

interface SearchResultView {
    fun setData(data: List<UiProperty>)
    fun showToast(@StringRes msg: Int)
}
