package com.example.semeterprojeclibrarysystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult

class login : AppCompatActivity() {

   lateinit var  db : dbhandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        db = dbhandler(this)


    }


    fun signin(view: View){

        val cms_field = findViewById<EditText>(R.id.cms)
        val password_field = findViewById<EditText>(R.id.password)

        var data = db.readData(db.readableDatabase)

        val cms = cms_field.text.toString()
        val pass= password_field.text.toString().trim()

        if(cms_field.text.isNullOrBlank() || password_field.text.isNullOrBlank()){
            Toast.makeText(this,"Please fill all the fields", Toast.LENGTH_LONG).show()
        }else{

            if(cms.toInt() == data[0].cms.toInt() && pass == data[0].password){

                   val intent = Intent(this,dashboard::class.java)
                    intent.putExtra("cms",cms)
                    intent.putExtra("name",data[0].name)

                    startActivity(intent)
            }

        }


//
//        Log.d("issue",""+ data[0].cms)

//        for(i in 0..data.size){
//            text.append(data[i].cms)
//        }
//           val intent = Intent(this,dashboard::class.java)

    }
}