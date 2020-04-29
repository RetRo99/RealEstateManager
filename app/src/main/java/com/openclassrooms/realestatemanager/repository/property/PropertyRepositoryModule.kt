package com.openclassrooms.realestatemanager.repository.property

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PropertyRepositoryModule {

    @Provides
    @Singleton
    fun providePropertyModule(): PropertyRepository {
        return PropertyRepositoryImpl()
    }

}
