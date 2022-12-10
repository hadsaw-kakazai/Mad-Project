package com.example.semeterprojeclibrarysystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val i = Intent(this, login::class.java)
            startActivity(i)
        }, 2000)




//        val intent : Intent = Intent(this,login::class.java)
//        Thread.sleep(2000)
//        startActivity(intent)


    }



}