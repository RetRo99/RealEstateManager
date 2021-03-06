package com.openclassrooms.realestatemanager.ui

import com.openclassrooms.realestatemanager.ui.loanFragment.LoanFragment
import com.openclassrooms.realestatemanager.ui.loanFragment.LoanFragmentModule
import com.openclassrooms.realestatemanager.ui.map.MapFragment
import com.openclassrooms.realestatemanager.ui.map.MapModule
import com.openclassrooms.realestatemanager.ui.photoFragment.PhotoFragment
import com.openclassrooms.realestatemanager.ui.photoFragment.PhotoFragmentModule
import com.openclassrooms.realestatemanager.ui.propertyAdd.PropertyAddFragment
import com.openclassrooms.realestatemanager.ui.propertyAdd.PropertyAddModule
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsFragment
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsModule
import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListFragment
import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListModule
import com.openclassrooms.realestatemanager.ui.searchProperty.PropertySearchFragment
import com.openclassrooms.realestatemanager.ui.searchProperty.PropertySearchModule
import com.openclassrooms.realestatemanager.ui.searchResult.SearchResultFragment
import com.openclassrooms.realestatemanager.ui.searchResult.SearchResultModule
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

    @ContributesAndroidInjector(modules = [PropertySearchModule::class])
    fun contribPropertySearchFragmentInjector(): PropertySearchFragment

    @ContributesAndroidInjector(modules = [SearchResultModule::class])
    fun contribPropertySearchResultFragmentInjector(): SearchResultFragment

    @ContributesAndroidInjector(modules = [PhotoFragmentModule::class])
    fun contribPhotoFragmentInjector(): PhotoFragment

    @ContributesAndroidInjector(modules = [LoanFragmentModule::class])
    fun contribLoanFragmentInjector(): LoanFragment

}
