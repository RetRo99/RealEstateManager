package com.openclassrooms.realestatemanager.utils

import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun providePropertyFormatter(): PropertyFormatter {
        return PropertyFormatter()
    }

}
