package com.openclassrooms.realestatemanager.ui

import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListFragment
import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface UiModule {

    @ContributesAndroidInjector(modules = [PropertyListModule::class])
    fun contributeMapFragmentInjector(): PropertyListFragment

}
