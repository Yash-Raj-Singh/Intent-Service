package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start.setOnClickListener{
            val intent = Intent(this, MyIntentService::class.java)
            MyIntentService.enqueueWork(this, intent)
            tvText.text = "Service Running"
        }

        stop.setOnClickListener{
            MyIntentService.stopService()
            tvText.text = "Service Stopped"
        }
    }
}