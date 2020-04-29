package com.openclassrooms.realestatemanager.manager.location

import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import io.reactivex.subjects.BehaviorSubject

class LocationManager(
    private val fusedLocationClient: FusedLocationProviderClient
) {

    val location: BehaviorSubject<Location> = BehaviorSubject.create()

    @SuppressLint("MissingPermission")
    fun updateLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    this.location.onNext(it)
                }
            }
    }

}
