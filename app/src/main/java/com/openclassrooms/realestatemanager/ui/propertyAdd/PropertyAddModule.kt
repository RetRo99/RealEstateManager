package com.openclassrooms.realestatemanager.ui.propertyAdd

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module

@Module
interface PropertyAddModule {

    @Binds
    fun bindView(fragment: PropertyAddFragment): PropertyAddView

    @Binds
    fun bindPresenter(presenterImpl: PropertyAddPresenterImpl): PropertyAddPresenter

    @Binds
    fun bindFragment(fragment: PropertyAddFragment): Fragment
}
