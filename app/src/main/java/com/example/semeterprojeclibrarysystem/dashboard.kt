package com.example.semeterprojeclibrarysystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class dashboard : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var nav: NavigationView
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val name = intent.extras?.get("name")
        val cms = intent.extras?.get("cms")


        val name_field = findViewById<TextView>(R.id.username)
        val cms_field = findViewById<TextView>(R.id.cms_show)

        name_field.text = "Hadsaw"

        cms_field.text = "023-19-0018"


        nav = findViewById(R.id.navView)

       nav.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.renew -> {
                val intent  = Intent(this,renew::class.java)
               startActivity(intent)
            }


            R.id.reminder -> {
                val intent  = Intent(this,reminder::class.java)
                startActivity(intent)
            }


            R.id.bookList -> {
                val intent  = Intent(this,iussuedBooksList::class.java)
                startActivity(intent)
            }

        }

        return true
    }



    fun checkissuedbook(view: View) {
        val intent = Intent(this, iussuedBooksList::class.java)
        startActivity(intent)
    }
}
