package com.example.quest9

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun doService(param: String) {
        println("do service $param")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("onstartcommand")
        //startForeground(1, )


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("Service", "Service onDestroy")
        super.onDestroy()
    }

    inner class LocalBinder : Binder() {
        fun getService() = this@MyService
    }

    private val binder = LocalBinder()

}