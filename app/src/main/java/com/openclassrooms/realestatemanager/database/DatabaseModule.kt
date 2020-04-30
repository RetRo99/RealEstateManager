package com.openclassrooms.realestatemanager.database

import com.openclassrooms.realestatemanager.database.property.PropertyDatabaseModule
import dagger.Module

@Module(
    includes = [
        PropertyDatabaseModule::class
    ]
)
class DatabaseModule
