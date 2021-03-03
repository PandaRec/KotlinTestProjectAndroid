package com.example.kotlintestprojectandroid

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var isPaused = false
    var seconds = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonStart.setOnClickListener { isPaused=false; runTimer()}
        buttonPause.setOnClickListener { isPaused=true }
        buttonReset.setOnClickListener { seconds=0; isPaused = true;textViewTimer.text="0:00:00" }
    }

    fun runTimer(){
        val handler = Handler()
        handler.post(object:Runnable{
            override fun run() {
                if(isPaused) return
                handler.postDelayed(this,1000)
                    seconds++
                val hours = seconds / 3600
                val minutes = seconds % 3600 / 60
                val secs = seconds % 60
                    textViewTimer.text = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs)

            }
        })
    }
}