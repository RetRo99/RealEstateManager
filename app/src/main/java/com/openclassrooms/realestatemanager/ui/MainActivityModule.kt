package com.openclassrooms.realestatemanager.ui

import android.app.Activity
import dagger.Binds
import dagger.Module

@Module(includes = [UiModule::class])
internal interface MainActivityModule {

    @Binds
    fun bindActivity(activity: MainActivity): Activity

    @Binds
    fun bindView(activity: MainActivity): MainView

    @Binds
    fun bindPresenter(presenterImpl: MainPresenterImpl): MainViewPresenter

}

