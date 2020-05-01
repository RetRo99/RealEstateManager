package com.openclassrooms.realestatemanager.base.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import com.squareup.moshi.JsonClass

@Entity(tableName = UiPropertyDetail.TABLE_NAME)
data class UiPropertyDetail(
    @ColumnInfo(name = TYPE)
    val type: String,
    @ColumnInfo(name = AGENT_NAME)
    val agentName: String,
    @ColumnInfo(name = SURFACE)
    val surface: String,
    @ColumnInfo(name = NUMBER_OF_ROOMS)
    val numberOfRooms: String,
    @ColumnInfo(name = DESCRIPTION)
    val description: String,
    @ColumnInfo(name = PRICE)
    val price: Double,
    @ColumnInfo(name = ADDRESS)
    val address: Address,
    @ColumnInfo(name = PUBLISHED_DATE)
    val publishedDate: String,
    @ColumnInfo(name = INTEREST_POINTS)
    val interestPoints: List<String>,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = PHOTOS)
    val photos: List<String> = listOf(),
    @ColumnInfo(name = LAT)
    val lat: Double = 0.0,
    @ColumnInfo(name = LNG)
    val lng: Double = 0.0,
    @ColumnInfo(name = IS_SOLD)
    val isSold: Boolean = false ,
    @ColumnInfo(name = SOLD_DATE)
    val soldDate: String = ""
) {

    val latLng: LatLng
        get() {
            return LatLng(lat, lng)
        }

    fun matchesCriteria(params:PropertySearchParams):Boolean{
        return true
    }

    companion object {
        const val TABLE_NAME = "property_details_table"
        const val TYPE = "type"
        const val AGENT_NAME = "agent_name"
        const val SURFACE = "surface"
        const val NUMBER_OF_ROOMS = "number_of_rooms"
        const val DESCRIPTION = "description"
        const val PRICE = "price"
        const val ADDRESS = "address"
        const val INTEREST_POINTS = "interest_points"
        const val PHOTOS = "photos"
        const val PUBLISHED_DATE = "published_date"
        const val LAT = "lat"
        const val LNG = "lng"
        const val IS_SOLD = "is_sold"
        const val SOLD_DATE = "sold_date"


    }


}

@JsonClass(generateAdapter = true)
data class Address(
    val number: String,
    val street: String,
    val postalCode: String,
    val city: String
) {

    override fun toString(): String {
        return "$number $street, $postalCode $city"
    }
}

