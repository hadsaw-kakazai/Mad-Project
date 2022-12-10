package com.example.semeterprojeclibrarysystem

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class customebaseadapter(private val context: Activity, private val books: ArrayList<issuedBooks>
):ArrayAdapter<issuedBooks>(context,R.layout.list_item,books) {


    override fun getView(position: Int, convertview: View?, parent: ViewGroup): View {

            val inflater = LayoutInflater.from(context)
            val view: View =  inflater.inflate(R.layout.list_item,null);


            val book : ImageView = view.findViewById(R.id.book)
            val bookTitle : TextView = view.findViewById(R.id.Title)
            val author : TextView = view.findViewById(R.id.author)
            val issuedate : TextView = view.findViewById(R.id.issueDate)
            val duedate : TextView = view.findViewById(R.id.duedate)


            book.setImageResource(books[position].cover)
            bookTitle.text = books[position].title
            author.text = books[position].author
            issuedate.text = books[position].issuedate
            duedate.text = books[position].duedate




        return view
    }


}