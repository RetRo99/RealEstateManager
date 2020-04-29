package com.openclassrooms.realestatemanager.repository.property

import com.retar.go4lunch.manager.firebase.firestore.FireStoreManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UsersRepositoryModule {

    @Provides
    @Singleton
    fun providePropertyModule(): PropertyRepository {
        return UsersRepositoryImpl(
            fireStoreManager
        )
    }

}
