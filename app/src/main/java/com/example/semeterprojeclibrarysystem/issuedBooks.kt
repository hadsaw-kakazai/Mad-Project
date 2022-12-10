package com.example.semeterprojeclibrarysystem

class issuedBooks {


    var iban : Int = 0
    var title :String = ""
    var cover : Int = 0
    var author :String = ""
    var issuedate : String = ""
    var duedate : String = ""


    constructor(issuedate:String,duedate:String, title : String,  author:String,cover:Int){
        this.title = title
        this.author = author
        this.issuedate = issuedate
        this.duedate = duedate
        this.cover = cover

    }

    constructor(){}
}