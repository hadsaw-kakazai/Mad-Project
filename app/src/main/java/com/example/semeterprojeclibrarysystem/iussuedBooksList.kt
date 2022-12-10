package com.example.semeterprojeclibrarysystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class iussuedBooksList : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var nav: NavigationView
    lateinit var  db : dbhandler
    lateinit var books : ArrayList<issuedBooks>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iussued_books_list)

        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav = findViewById(R.id.navView)

        nav.setNavigationItemSelectedListener(this)


       val issuebook = issuedBooks("13-12-2022","23-12-2022","Deep Discord","Charles M",R.drawable._2)
       val issuebook1 = issuedBooks("15-12-2022","25-12-2022","The Death Of Vivek","Awaeke Emezi",R.drawable._6)
       val issuebook2 = issuedBooks("10-12-2022","20-12-2022","Half Baked Idea","Oliva Potts",R.drawable._4)


        val listview = findViewById<ListView>(R.id.booklist)
//        var data = db.readDataBooks(db.readableDatabase)

        books = ArrayList()
        books.add(issuebook)
        books.add(issuebook1)
        books.add(issuebook2)



        listview.adapter = customebaseadapter(this,books)



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


            R.id.renew -> {
                val intent = Intent(this, renew::class.java)
                startActivity(intent)
            }

        }
        return true
    }

    fun returnNow(view: View){
        val intent = Intent(this,reminder::class.java)
        startActivity(intent)
    }
    }
