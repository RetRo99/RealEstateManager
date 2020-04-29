package com.openclassrooms.realestatemanager.repository

import dagger.Module

@Module(
    includes = [
        RestaurantsRepositoryModule::class,
    ]
)
class RepositoryModule
