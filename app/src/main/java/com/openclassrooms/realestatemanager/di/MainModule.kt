package com.openclassrooms.realestatemanager.di

import com.openclassrooms.realestatemanager.manager.ManagerModule
import com.openclassrooms.realestatemanager.repository.RepositoryModule
import dagger.Module


@Module(
    includes = [
        RepositoryModule::class,
        ManagerModule::class
    ]
)class MainModule
