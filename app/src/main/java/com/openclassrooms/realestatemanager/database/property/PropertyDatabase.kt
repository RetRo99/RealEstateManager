package com.openclassrooms.realestatemanager.database.property

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.database.converters.StringListConverter
import com.openclassrooms.realestatemanager.database.property.PropertyDatabase.Companion.DB_VERSION

@Database(entities = [UiPropertyDetail::class], version = DB_VERSION)
@TypeConverters(StringListConverter::class)
abstract class PropertyDatabase : RoomDatabase() {
    abstract fun propertyDao(): PropertyDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "properties"
    }
}
