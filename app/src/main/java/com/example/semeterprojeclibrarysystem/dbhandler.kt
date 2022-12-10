package com.example.semeterprojeclibrarysystem

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast


var Table_name = "user"
var name = "NAME"
var cms = "CMS"
var password = "PASSWORD"
//here is the book table data

var table_book = "book"
var iban = "IBAN"
var title = "Title"
var author = "Author"

//here is the issued book on the specific cms table data

var table_issuebook = "issuedbook"
var issuedate = "date_of_issue"
var duedate = "due_date"
var amount= "amount"


class dbhandler(
    context: Context?


) : SQLiteOpenHelper(context, "siba_lib", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val creatTable = "CREATE TABLE user (CMS INTEGER PRIMARY KEY, NAME TEXT, PASSWORD TEXT)".trim()
        val create_issued_book = "CREATE TABLE issuedbooks (iban INTEGER PRIMARY KEY, title TEXT, author TEXT, issuedate TEXT, duedate TEXT)".trim()



        db?.execSQL(creatTable)
        db?.execSQL(create_issued_book)


        val user = user(18,"123","hadsaw")
//        val issuebook = issuedBooks(1,"13-12-2022","23-12-2022","Deep Discord","Charles M")
//        val issuebook1 = issuedBooks(2,"15-12-2022","25-12-2022","The Death Of Vivek","Awaeke Emezi")
//        val issuebook2 = issuedBooks(3,"10-12-2022","20-12-2022","Half Baked Idea","Oliva Potts")
//
//
//        insertData(user,db)
//        insertData(issuebook,db)
//        insertData(issuebook1,db)
//        insertData(issuebook2,db)

    }


    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL("DROP TABLE IF EXISTS $Table_name")
        onCreate(db);
    }


    fun insertData(u:user,db: SQLiteDatabase?){



            var cv = ContentValues()
            cv.put(cms, u.cms)
            cv.put(name, u.name)
            cv.put(password, u.password)


            var result = db?.insert(Table_name, null, cv)
            if (result == (-1).toLong()) {
                Log.d("issue", "some issue occured")
            }


        }



    fun insertData(ib:issuedBooks,db: SQLiteDatabase?){



        var cv = ContentValues()
        cv.put("iban", ib.iban)
        cv.put("title",ib.title)
        cv.put("author",ib.author)
        cv.put("issuedate",ib.issuedate)
        cv.put("duedate",ib.duedate)

        var result = db?.insert("issuedbooks", null, cv)
        if (result == (-1).toLong()) {
            Log.d("issue", "some issue occured")
        }


    }


    fun readData(db: SQLiteDatabase?):MutableList<user>{
        var list : MutableList<user> = ArrayList()



        val query = "Select * from $Table_name".trim()

        val result = db?.rawQuery(query, null)
        if (result!!.moveToFirst()) {
            do {
                var u = user()
                u.cms = result.getString(0).toInt()
                u.name = result.getString(1)
                u.password = result.getString(2)

                list.add(u)
            } while (result.moveToNext())
        }

        result.close()



        return list

    }


//
//
//    fun readDataBooks(db: SQLiteDatabase?):MutableList<issuedBooks>{
//        var list : MutableList<issuedBooks> = ArrayList()
//
//// iban INTEGER PRIMARY KEY, title TEXT, author TEXT, issuedate TEXT, duedate TEXT
//
//        val query = "Select * from issuedbooks".trim()
//
//        val result = db?.rawQuery(query, null)
//        if (result!!.moveToFirst()) {
//            do {
//                var book = issuedBooks()
//                book.iban = result.getString(0).toInt()
//                book.title = result.getString(1)
//                book.author = result.getString(2)
//                book.issuedate = result.getString(3)
//                book.duedate = result.getString(4)
//
//                list.add(book)
//            } while (result.moveToNext())
//        }
//
//        result.close()
//
//
//
//        return list
//
//    }
}











