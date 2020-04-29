package com.openclassrooms.realestatemanager.ui.propertyList

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module

@Module
interface PropertyListModule {

    @Binds
    fun bindView(fragment: PropertyListFragment): PropertyListView

    @Binds
    fun bindPresenter(presenterImpl: PropertyListPresenterImpl): PropertyListPresenter

    @Binds
    fun bindFragment(fragment: PropertyListFragment): Fragment
}
