package com.openclassrooms.realestatemanager.manager.auth

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseAuthManagerModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }


    @Provides
    @Singleton
    fun provideAuthManager(auth: FirebaseAuth): FirebaseAuthManager {
        return FirebaseAuthManager(
            auth
        )
    }

}
