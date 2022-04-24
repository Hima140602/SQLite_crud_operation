package com.hima.internalpracticaldemo

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_sqlite_demo_internal_practice.*

class SQLiteDemoInternalPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_demo_internal_practice)
        btninsert.setOnClickListener {
            var name = edtfname.text.toString()
            var desc = edtfdesc.text.toString()
            var qty = edtfqty.text.toString().toInt()
            var price = edtfprice.text.toString().toInt()
            var fruit = Fruit(name,desc,qty,price)
            var db = DBHelper(this)
            var flag = db.insert(fruit)
            if(flag){
                Toast.makeText(this,"Record Inserted Successfully",Toast.LENGTH_LONG).show()
            }
        }
        btnviewall.setOnClickListener {
            var intent = Intent(this,ViewAll::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Sample Dialog")
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setMessage("Are you sure you can exit")
        builder.setPositiveButton("Yes",
            DialogInterface.OnClickListener{dialogInterface, i -> finish() })
        builder.setNegativeButton("No",
        DialogInterface.OnClickListener{dialogInterface, i ->
            Toast.makeText(this,"Thank You",Toast.LENGTH_LONG).show()
        })
        var dialog = builder.create()
        dialog.setCancelable(false)
        dialog.show()
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if(id.equals(R.id.menulogout))
        {
            var sp: SharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE)
            var prefedit = sp.edit()
            prefedit.clear()
            prefedit.commit()
            var intent = Intent(this,login_activity::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}