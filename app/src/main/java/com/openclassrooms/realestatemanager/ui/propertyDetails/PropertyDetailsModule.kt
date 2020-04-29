package com.openclassrooms.realestatemanager.ui.propertyDetails

import androidx.fragment.app.Fragment
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsFragment
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsPresenter
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsPresenterImpl
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsView
import dagger.Binds
import dagger.Module

@Module
interface PropertyDetailsModule {

    @Binds
    fun bindView(fragment: PropertyDetailsFragment): PropertyDetailsView

    @Binds
    fun bindPresenter(presenterImpl: PropertyDetailsPresenterImpl): PropertyDetailsPresenter

    @Binds
    fun bindFragment(fragment: PropertyDetailsFragment): Fragment
}
