package com.openclassrooms.realestatemanager.ui

import com.openclassrooms.realestatemanager.ui.map.MapFragment
import com.openclassrooms.realestatemanager.ui.map.MapModule
import com.openclassrooms.realestatemanager.ui.propertyAdd.PropertyAddFragment
import com.openclassrooms.realestatemanager.ui.propertyAdd.PropertyAddModule
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsFragment
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsModule
import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListFragment
import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface UiModule {

    @ContributesAndroidInjector(modules = [PropertyListModule::class])
    fun contributePropertyListFragmentInjector(): PropertyListFragment

    @ContributesAndroidInjector(modules = [PropertyDetailsModule::class])
    fun contributePropertyDetailsFragmentInjector(): PropertyDetailsFragment

    @ContributesAndroidInjector(modules = [MapModule::class])
    fun contributeMapFragmentInjector(): MapFragment

    @ContributesAndroidInjector(modules = [PropertyAddModule::class])
    fun contribPropertyAddFragmentInjector(): PropertyAddFragment

}
