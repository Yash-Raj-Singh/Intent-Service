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
//            val intent = Intent(this, MyIntentService::class.java)
//            MyIntentService.enqueueWork(this, intent)

                Intent(this, MyService::class.java).also {
                startService(it)
                tvText.text = "Service Running"
            }

        }

        stop.setOnClickListener{
            Intent(this, MyService::class.java).also {
                stopService(it)
                tvText.text = "Service Stopped"
            }
        }

        send.setOnClickListener{
            Intent(this, MyService::class.java).also {
                val dataString = etEdit.text.toString()
                it.putExtra("Extra Data", dataString)
                startService(it)
            }
        }
    }
}