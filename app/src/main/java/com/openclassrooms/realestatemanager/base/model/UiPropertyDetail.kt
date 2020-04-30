package com.openclassrooms.realestatemanager.base.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiPropertyDetail(
    val type: String,
    val agentName: String,
    val surface: Double,
    val numberOfRooms: Double,
    val description :String,
    val price: Double,
    val address: Address,
    val interestPoints: List<String>,
    val id:String = ""
) : Parcelable

@Parcelize
data class Address(val number: String, val street: String, val postalCode: Int, val city: String) :
    Parcelable
