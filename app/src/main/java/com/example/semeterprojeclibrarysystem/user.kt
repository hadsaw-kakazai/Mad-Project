package com.example.semeterprojeclibrarysystem

class user {

    var cms : Int = 0
    var name : String = ""
    var password : String = ""

    constructor(){}
    constructor(cms:Int,password:String, name:String){
        this.cms = cms
        this.name = name
        this.password = password

    }

}