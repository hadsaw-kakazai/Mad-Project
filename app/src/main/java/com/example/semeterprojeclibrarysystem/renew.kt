package com.example.semeterprojeclibrarysystem

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class renew : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var date : TextView
    lateinit var btndatepicker : Button
    lateinit var nav: NavigationView
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_renew)
        nav = findViewById(R.id.navView)

        nav.setNavigationItemSelectedListener(this)
        date  = findViewById<TextView>(R.id.date)
        btndatepicker = findViewById<Button>(R.id.newdate)

        val calendar = Calendar.getInstance()

        var datepicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayofmonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayofmonth)
            updatelabel(calendar)
        }

            btndatepicker.setOnClickListener {

                 DatePickerDialog(this,datepicker,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()


            }



        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashboard -> {
                val intent = Intent(this, dashboard::class.java)
                startActivity(intent)
            }


            R.id.reminder -> {
                val intent = Intent(this, reminder::class.java)
                startActivity(intent)
            }


            R.id.bookList -> {
                val intent = Intent(this, iussuedBooksList::class.java)
                startActivity(intent)
            }

        }
        return true
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun updatelabel(calendar: Calendar?) {
            val format = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(format,Locale.US)
        if (calendar != null) {
            date.text = sdf.format(calendar.time)
        }

        Toast.makeText(this,"Your Request Has been submitted",Toast.LENGTH_LONG).show()
    }


}