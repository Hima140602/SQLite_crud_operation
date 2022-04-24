package com.hima.internalpracticaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.edtfname
import kotlinx.android.synthetic.main.activity_sqlite_demo_internal_practice.*

class registration_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnregistration.setOnClickListener(){
            var fname = edtfname.text.toString()
            var lname = edtlname.text.toString()
            var email = edtemail.text.toString()
            var password = edtpassword.text.toString()
            var regi = Registration(fname,lname,email,password)
            var db = DBHelper(this)
            var flag = db.insert1(regi)
            if(flag)
            {
                Toast.makeText(this,"Record inserted successfully", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
            }
        }
        btnbeforelogin.setOnClickListener{
            var intent = Intent(this,login_activity::class.java)
            startActivity(intent)
        }
    }
}