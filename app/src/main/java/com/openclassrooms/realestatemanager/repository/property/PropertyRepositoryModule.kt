package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.database.property.PropertyDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PropertyRepositoryModule {

    @Provides
    @Singleton
    fun providePropertyModule(propertyDao: PropertyDao): PropertyRepository {
        return PropertyRepositoryImpl(propertyDao)
    }

}


