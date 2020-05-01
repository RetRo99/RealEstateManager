package com.openclassrooms.realestatemanager.ui.searchResult

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module

@Module
interface SearchResultModule {

    @Binds
    fun bindView(fragment: SearchResultFragment): SearchResultView

    @Binds
    fun bindPresenter(presenterImpl: SearchResultPresenterImpl): SearchResultPresenter

    @Binds
    fun bindFragment(fragment: SearchResultFragment): Fragment
}
