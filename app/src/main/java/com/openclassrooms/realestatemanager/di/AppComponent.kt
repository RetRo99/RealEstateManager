package com.openclassrooms.realestatemanager.di

import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Component(modules = [AppModule::class])
@Singleton
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<BaseApplication>

}
