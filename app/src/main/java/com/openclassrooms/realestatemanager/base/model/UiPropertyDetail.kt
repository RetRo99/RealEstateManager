package com.openclassrooms.realestatemanager.base.model


data class UiPropertyDetail(
    val type: String,
    val agentName: String,
    val surface: Double,
    val numberOfRooms: Double,
    val price: Double,
    val address: Address,
    val interestPoints: List<String>
)

data class Address(val number: String, val street: String, val postalCode: Int, val city: String)
