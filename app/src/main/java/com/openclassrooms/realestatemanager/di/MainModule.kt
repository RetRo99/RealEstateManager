package com.openclassrooms.realestatemanager.di

import com.openclassrooms.realestatemanager.database.DatabaseModule
import com.openclassrooms.realestatemanager.manager.ManagerModule
import com.openclassrooms.realestatemanager.repository.RepositoryModule
import com.openclassrooms.realestatemanager.retrofit.RetrofitModule
import com.openclassrooms.realestatemanager.utils.UtilsModule
import dagger.Module


@Module(
    includes = [
        RepositoryModule::class,
        ManagerModule::class,
        DatabaseModule::class,
        RetrofitModule::class,
        UtilsModule::class
    ]
)class MainModule
