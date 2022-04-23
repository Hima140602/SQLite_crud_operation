package com.hima.internalpracticaldemo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelper(var context:Context)
    : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION){

    companion object{
        private var DB_NAME = "FruitDB"
        private var TB_NAME = "FruitDetails"
        private var DB_VERSION = 1
        private var FR_NAME = "fr_name"
        private var FR_ID = "id"
        private var FR_PRICE = "fr_price"
        private  var FR_DESC = "fr_desc"
        private var FR_QTY = "fr_qty"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "CREATE TABLE $TB_NAME ( $FR_ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "$FR_NAME TEXT,$FR_DESC TEXT,$FR_QTY INTEGER,$FR_PRICE INTEGER)"
        p0?.execSQL(query);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query = "DROP TABLE $TB_NAME IF EXISTS"
        p0?.execSQL(query)
        onCreate(p0)
    }
    fun insert(fruit:Fruit):Boolean {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put(FR_NAME,fruit.fr_name)
        cv.put(FR_DESC,fruit.fr_desc)
        cv.put(FR_QTY,fruit.fr_qty)
        cv.put(FR_PRICE,fruit.fr_price)
        var flag = db.insert(TB_NAME,null,cv)
        if(flag>0)
        {
            return true
        }
        else{
            return false
        }
    }
    fun retriveall():ArrayList<Fruit>
    {
        var db= readableDatabase
        var cursor = db.query(TB_NAME, null,null ,null,null,null,null,null)
        var arr:ArrayList<Fruit> = ArrayList()
        while(cursor.moveToNext()){
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var desc = cursor.getString(2)
            var qty = cursor.getInt(3)
            var price = cursor.getInt(4)
            var fruit = Fruit(id,name,desc,qty,price)
            arr.add(fruit)
        }
        return arr
    }
    fun Delete(fruit:Fruit):Boolean{
        var db=writableDatabase
        var flag = db.delete(TB_NAME,"$FR_ID = ${fruit.id}",null)
        //delete from table_name where id = id
        if(flag>0)
        {
            return true
        }
        else{
            return false
        }
    }
    fun Update(fruit:Fruit):Boolean{
        var db =writableDatabase
        var cv = ContentValues()
        cv.put(FR_NAME,fruit.fr_name)
        cv.put(FR_DESC,fruit.fr_desc)
        cv.put(FR_QTY,fruit.fr_qty)
        cv.put(FR_PRICE,fruit.fr_price)
        var flag = db.update(TB_NAME,cv,"$FR_ID = ${fruit.id}",null)
        //update table tb_name set fr_name ,desc,price where id =
        if(flag>0)
            return true
        else
            return false
    }
}