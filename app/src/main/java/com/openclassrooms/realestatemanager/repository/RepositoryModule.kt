package com.openclassrooms.realestatemanager.repository

import com.openclassrooms.realestatemanager.repository.property.PropertyRepositoryModule
import dagger.Module

@Module(
    includes = [
        PropertyRepositoryModule::class
    ]
)
class RepositoryModule
