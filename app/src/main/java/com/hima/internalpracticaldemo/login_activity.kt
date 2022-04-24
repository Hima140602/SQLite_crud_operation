package com.hima.internalpracticaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin.setOnClickListener(){
            var email = edtloginemail.text.toString()
            var pass = edtloginpass.text.toString()
            var db = DBHelper(this)
            var arr = db.getuser(email)
            if((email.equals(arr[0].email)) &&(pass.equals(arr[0].password)) ){
                var intent = Intent(this,SQLiteDemoInternalPractice::class.java)
                startActivity(intent)
            }
        }
    }
}