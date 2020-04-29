package com.openclassrooms.realestatemanager.manager

import com.retar.go4lunch.manager.location.LocationManagerModule
import dagger.Module


@Module(
    includes = [
        LocationManagerModule::class
    ]
)
class ManagerModule
