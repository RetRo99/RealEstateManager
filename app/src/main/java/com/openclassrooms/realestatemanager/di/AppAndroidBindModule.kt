package com.openclassrooms.realestatemanager.di

import android.content.Context
import dagger.Binds
import dagger.Module

@Module
interface AppAndroidBindModule {

    @Binds
    fun bindContext(app: BaseApplication): Context

}
