package com.openclassrooms.realestatemanager.base.model

import android.net.Uri
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = UiPropertyDetail.TABLE_NAME)
data class UiPropertyDetail(
    @ColumnInfo(name = TYPE)
    val type: String,
    @ColumnInfo(name = AGENT_NAME)
    val agentName: String,
    @ColumnInfo(name = SURFACE)
    val surface: Double,
    @ColumnInfo(name = NUMBER_OF_ROOMS)
    val numberOfRooms: Double,
    @ColumnInfo(name = DESCRIPTION)
    val description: String,
    @ColumnInfo(name = PRICE)
    val price: Double,
    @ColumnInfo(name = ADDRESS)
    val address: String,
    @ColumnInfo(name = INTEREST_POINTS)
    val interestPoints: List<String>,
    @PrimaryKey
    val id: String = "",
    @ColumnInfo(name = PHOTOS)
    val photos: List<String> = listOf()
) : Parcelable {
    companion object{
        const val TABLE_NAME="property_details_table"
        const val TYPE = "type"
        const val AGENT_NAME ="agent_name"
        const val SURFACE = "surface"
        const val NUMBER_OF_ROOMS = "number_of_rooms"
        const val DESCRIPTION = "description"
        const val PRICE = "price"
        const val ADDRESS = "address"
        const val INTEREST_POINTS = "interest_points"
        const val PHOTOS = "photos"


    }
}
