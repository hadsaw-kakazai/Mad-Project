package com.example.semeterprojeclibrarysystem

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class alarmreceiver : BroadcastReceiver() {

    var message = ""
    override fun onReceive(context: Context?, i: Intent?) {
        val intent = Intent(context,login::class.java)
        i!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent =  PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(context!!, "SIBA Library App")
            .setSmallIcon(R.drawable.logo)
            .setContentTitle("Your Reminder")
            .setContentText(message)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)


        val notification_manager = NotificationManagerCompat.from(context)
        notification_manager.notify(123,builder.build())
    }


}