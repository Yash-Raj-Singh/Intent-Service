package com.example.intentservice

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyIntentService : JobIntentService() {

    init {
        instance = this
    }

    companion object{
        private lateinit var instance: MyIntentService
        var isRunning  = false

        val JOB_ID = 1
        val TAG = "Tag"

        fun enqueueWork(context: Context, intent: Intent){
            enqueueWork(context, MyIntentService::class.java, JOB_ID, intent)
        }

        fun stopService(){
            Log.d("MyIntentService", "Service is Stopped.....")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleWork(intent: Intent) {
        try {
            isRunning = true
            while (isRunning){
                Log.d("MyIntentService", "Service is now Running.....")
                Thread.sleep(1000)
            }
        }catch (e:InterruptedException){
            Log.d("MyIntentService", "Some error")
            Thread.currentThread().interrupt()
        }
    }
}