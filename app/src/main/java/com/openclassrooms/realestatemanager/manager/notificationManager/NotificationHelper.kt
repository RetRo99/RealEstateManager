package com.openclassrooms.realestatemanager.manager.notificationManager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.openclassrooms.realestatemanager.R
import dagger.android.support.DaggerAppCompatActivity

class NotificationHelper(private val context: Context) {

    fun createAddedNotification(id: Int) {

        createNotificationChannel()

        val builder = NotificationCompat.Builder(context, context.getString(R.string.channel_id))
            .setSmallIcon(R.drawable.ic_house)
            .setContentTitle(context.getString(R.string.notification_title))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(getPendingIntent(id))
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(NEW_ADDED_REMINDER, builder.build())

        }

    }

    fun createUpdatedNotification(id: Int) {

        createNotificationChannel()

        val builder = NotificationCompat.Builder(context, context.getString(R.string.channel_id))
            .setSmallIcon(R.drawable.ic_house)
            .setContentTitle(context.getString(R.string.notification_title_update))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(getPendingIntent(id))
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(UPDATED_REMINDER, builder.build())

        }

    }

    private fun getPendingIntent(id: Int): PendingIntent {

        val bundle = Bundle().apply {
            putInt("id", id)
        }
        return NavDeepLinkBuilder(context)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.propertyDetailsFragment)
            .setArguments(bundle)
            .createPendingIntent()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.channel_name)
            val descriptionText = context.getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel =
                NotificationChannel(context.getString(R.string.channel_id), name, importance)
            mChannel.description = descriptionText
            val notificationManager =
                context.getSystemService(DaggerAppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }


    companion object {
        private const val NEW_ADDED_REMINDER = 12
        private const val UPDATED_REMINDER = 12
    }

}
