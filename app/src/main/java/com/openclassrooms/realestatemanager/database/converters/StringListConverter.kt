package com.openclassrooms.realestatemanager.database.converters

import androidx.room.TypeConverter

class StringListConverter {
    @TypeConverter
    fun fromString(stringListString: String): List<String> {
        return if (stringListString.isNotBlank()) {
            stringListString.split(",").map { it }
        }else{
            listOf()
        }
    }

    @TypeConverter
    fun toString(stringList: List<String>): String {
        return stringList.joinToString(separator = ",")
    }
}
