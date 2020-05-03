package com.openclassrooms.realestatemanager.manager

import com.openclassrooms.realestatemanager.manager.auth.FirebaseAuthManagerModule
import com.retar.go4lunch.manager.location.LocationManagerModule
import dagger.Module


@Module(
    includes = [
        LocationManagerModule::class,
        FirebaseAuthManagerModule::class

    ]
)
class ManagerModule
