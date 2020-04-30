package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.database.property.PropertyDao
import com.openclassrooms.realestatemanager.retrofit.GeocodingApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PropertyRepositoryModule {

    @Provides
    @Singleton
    fun providePropertyModule(propertyDao: PropertyDao, api:GeocodingApi): PropertyRepository {
        return PropertyRepositoryImpl(propertyDao, api)
    }

}


