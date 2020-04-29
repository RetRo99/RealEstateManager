package com.openclassrooms.realestatemanager.di

import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule


@Module(includes = [AndroidSupportInjectionModule::class, UiInjectorModule::class, AppAndroidBindModule::class, MainModule::class])
class AppModule
