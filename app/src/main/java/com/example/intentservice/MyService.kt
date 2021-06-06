package com.example.intentservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {

    val TAG = "com.example.intentservice.MyService"

    init {
        Log.d(TAG, "Service is started.....")
    }

    override fun onBind(intent: Intent?): IBinder?  = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val dataString = intent?.getStringExtra("Extra Data")

        dataString?.let {
            Log.d(TAG, dataString)
        }

        // JUST SHOWING INFINITE LOOP IF PUT OUTSIDE THE NEW THREAD WILL
        //BLOCK THE MAIN THREAD SO WE ARE PUTTING IT IN A NEW THREAD
        //THIS CODE BELOW DOES NOTHING TO THE APPLICATION.
        Thread{
            while (true){}
        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "Service is being killed.....")
    }
}