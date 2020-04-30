package com.openclassrooms.realestatemanager.retrofit.response


data class GeocodeResult(

    val results: List<Results>
)

data class Results(val geometry: Geometry)

data class Geometry(

    val location: Location
)

data class Location(

    val lat: Double,
    val lng: Double
)
