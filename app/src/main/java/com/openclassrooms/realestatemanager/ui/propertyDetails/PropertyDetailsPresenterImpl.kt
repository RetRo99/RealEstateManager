package com.openclassrooms.realestatemanager.ui.propertyDetails

import android.util.Log
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import javax.inject.Inject

class PropertyDetailsPresenterImpl @Inject constructor(
    private val view: PropertyDetailsView
) : PropertyDetailsPresenter {


    override fun onViewCreated(id: String) {
        Log.d("čič", id)
    }

}
