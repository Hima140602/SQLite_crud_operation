package com.hima.internalpracticaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if(id.equals(R.id.menulogout))
        {

        }
        return true
    }
}