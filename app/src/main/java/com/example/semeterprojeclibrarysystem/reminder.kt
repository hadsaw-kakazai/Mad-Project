package com.example.semeterprojeclibrarysystem

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Binder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.ContentInfoCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.semeterprojeclibrarysystem.databinding.ActivityMainBinding
import com.example.semeterprojeclibrarysystem.databinding.ActivityReminderBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class reminder : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var nav: NavigationView
    private lateinit var binding : ActivityReminderBinding
    lateinit var picker : MaterialTimePicker
    lateinit var alarmManager  : AlarmManager
    lateinit var calender : Calendar
    lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReminderBinding.inflate(layoutInflater)

        binding.setTime.setOnClickListener {

            showTimePicker()
        }

        binding.reminderOn.setOnClickListener{
                setReminder()
        }

        binding.reminderOff.setOnClickListener {

            offreminder()

        }
        setContentView(binding.root)
        createNotificationChannel()




        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav = findViewById(R.id.navView)

        nav.setNavigationItemSelectedListener(this)

    }

    private fun offreminder() {


        alarmManager  = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,alarmreceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent,PendingIntent.FLAG_IMMUTABLE)


        alarmManager.cancel(pendingIntent)

        Toast.makeText(this,"Reminder Turned off",Toast.LENGTH_LONG).show()


    }

    private fun setReminder() {
        alarmManager  = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,alarmreceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent,PendingIntent.FLAG_IMMUTABLE)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,calender.timeInMillis,
            AlarmManager.INTERVAL_DAY,pendingIntent
        )

        Toast.makeText(this,"You will be remind on select time. See you",Toast.LENGTH_LONG).show()
    }

    private fun showTimePicker() {

        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set Your Reminder Time").build()


        picker.show(supportFragmentManager,"SIBA")
        picker.addOnPositiveButtonClickListener {

            if(picker.hour>12){
                binding.time.text = String.format("%02d",picker.hour-12)+ " : " +String.format("%02d",picker.minute)+ "PM"
            }else{

                String.format("%02d",picker.hour-12)+ " : " +String.format("%02d",picker.minute)+ "AM"
            }


            calender = Calendar.getInstance()
            calender[Calendar.HOUR_OF_DAY] = picker.hour
            calender[Calendar.MINUTE] = picker.minute
            calender[Calendar.SECOND] = 0
            calender[Calendar.MILLISECOND] = 0

        }
    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name  = "reminder channel"
            val describe = "Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel("SIBA Library App",name,importance)
            channel.description = describe

            val notification_manager = getSystemService(
                NotificationManager::class.java
            )


            notification_manager.createNotificationChannel(channel)
        }

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashboard -> {
                val intent = Intent(this, dashboard::class.java)
                startActivity(intent)
            }


            R.id.renew -> {
                val intent = Intent(this, renew::class.java)
                startActivity(intent)
            }


            R.id.bookList -> {
                val intent = Intent(this, iussuedBooksList::class.java)
                startActivity(intent)
            }

        }
        return true
    }

}