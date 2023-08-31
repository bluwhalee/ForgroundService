package com.example.forgroundservice

import android.app.PendingIntent
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import java.security.Provider.Service

class RunningService: android.app.Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action)
        {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
    }
    private fun start(){
        val notification = NotificationCompat.Builder(this, "running-channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Run is active")
            .setContentText("service running")
            .build()
        Log.d("MyApp", "444")
        startForeground(1234, notification)
        Log.d("MyApp", "555")
    }

    enum class Actions{
        START, STOP
    }
}