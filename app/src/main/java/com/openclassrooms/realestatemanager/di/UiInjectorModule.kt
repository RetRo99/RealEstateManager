package com.openclassrooms.realestatemanager.di

import com.openclassrooms.realestatemanager.ui.MainActivity
import com.openclassrooms.realestatemanager.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal interface UiInjectorModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributeMainActivity(): MainActivity

}
