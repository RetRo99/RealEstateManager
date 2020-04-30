package com.openclassrooms.realestatemanager.database.property

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.repository.property.PropertyRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PropertyDatabaseModule {

    @Provides
    @Singleton
    fun providePropertyDatabase(context: Context): PropertyDatabase {
         return Room.databaseBuilder(context, PropertyDatabase::class.java, PropertyDatabase.DB_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun providePropertyDao(database: PropertyDatabase): PropertyDao {
        return database.propertyDao()
    }

}
