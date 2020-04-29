package com.openclassrooms.realestatemanager.ui.searchProperty

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module

@Module
interface PropertySearchModule {

    @Binds
    fun bindView(fragment: PropertySearchFragment): PropertySearchView

    @Binds
    fun bindPresenter(presenterImpl: PropertySearchPresenterImpl): PropertySearchPresenter

    @Binds
    fun bindFragment(fragment: PropertySearchFragment): Fragment
}
