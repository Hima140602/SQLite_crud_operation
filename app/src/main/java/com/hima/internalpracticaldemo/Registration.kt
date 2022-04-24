package com.hima.internalpracticaldemo

data class Registration(var fname:String,var lname:String,var email:String,var password:String)
{
    var id:Int = 0
    constructor(id:Int,fname: String,lname: String,email: String,password: String):
            this(fname,lname,email,password)
    {
                this.id= id
    }
}