package com.openclassrooms.realestatemanager.database.converters

import android.net.Uri
import androidx.room.TypeConverter

class UriConverter {

    @TypeConverter
    fun fromString(stringListString: String): List<Uri> {
        return stringListString.split(",").map {
            Uri.parse(it)
        }
    }

    @TypeConverter
    fun toString(uriList: List<Uri>): String {
        return uriList.joinToString(separator = ",")
    }
}
