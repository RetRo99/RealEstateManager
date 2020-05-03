package com.openclassrooms.realestatemanager.manager.notificationManager

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NotificationHelperModule {

    @Provides
    @Singleton
    fun provideNotificationHelper(context: Context): NotificationHelper {
        return NotificationHelper(
            context
        )
    }
}
