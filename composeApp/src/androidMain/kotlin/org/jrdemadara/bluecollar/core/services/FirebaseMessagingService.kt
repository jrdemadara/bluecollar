package org.jrdemadara.bluecollar.core.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.jrdemadara.bluecollar.MainActivity
import org.jrdemadara.bluecollar.R
import kotlin.random.Random

class FirebaseMessagingService : FirebaseMessagingService() {
    private val random = Random

    private fun sendNotification(message: RemoteMessage.Notification) {
        // If you want the notifications to appear when your app is in foreground

        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(FLAG_ACTIVITY_CLEAR_TOP)
        }

        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, FLAG_IMMUTABLE
        )

        val channelId = this.getString(R.string.default_notification_channel_id)

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle(message.title)
            .setContentText(message.body)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, CHANNEL_NAME, IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        manager.notify(random.nextInt(), notificationBuilder.build())
    }

    override fun onNewToken(token: String) {
        //FirebaseManager().onNewToken(token)
        Log.d("FCM","New token: $token")

    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        //FirebaseManager().onMessageReceived(remoteMessage.data.toString())
        remoteMessage.notification?.let { sendNotification(it) }
    }


    companion object {
        const val CHANNEL_NAME = "FCM notification channel"
    }
}