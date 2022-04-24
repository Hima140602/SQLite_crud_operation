package com.hima.internalpracticaldemo

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            if(arr.size<0){
                Toast.makeText(this,"User Doesn't Exist or Incorrect Email",Toast.LENGTH_LONG).show()
            }
            else{
                if(email.equals("") || pass.equals("")){
                    Toast.makeText(this,"Fill Data Accurately",Toast.LENGTH_LONG).show()
                }
                else if((email.equals(arr[0].email)) &&(pass.equals(arr[0].password)) ){
                    var sp:SharedPreferences = getSharedPreferences("Mypref", MODE_PRIVATE)
                    var predit = sp.edit()
                    predit.putString("Email",email)
                    predit.commit()
                    var intent = Intent(this,SQLiteDemoInternalPractice::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Incorrenct Password",Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}