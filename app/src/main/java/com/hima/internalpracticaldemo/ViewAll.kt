package com.hima.internalpracticaldemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_view_all.*
import kotlinx.android.synthetic.main.custom_dialog_layout.*
import kotlinx.android.synthetic.main.invoice_dialog_layout.*
import java.text.FieldPosition

class ViewAll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        updateRecuclerview()
    }
    public  fun delete(position:Int){
        var db = DBHelper(this)
        var arr = db.retriveall()
        var fruit = arr.get(position)
        //var id = fruit.id
        var flag = db.Delete(fruit)
        if(flag){
            Toast.makeText(this, "Record Deleted", Toast.LENGTH_LONG).show()
        }
        updateRecuclerview()
    }
    public fun update(position:Int){
        var db = DBHelper(this)
        var arr = db.retriveall()
        var fruit = arr.get(position)
        var id = fruit.id
        var name = fruit.fr_name
        var desc = fruit.fr_desc
        var qty = fruit.fr_qty
        var price = fruit.fr_price
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog_layout)
        dialog.txtid.setText(id.toString())
        dialog.edtdialogname.setText(name)
        dialog.edtdialogdesc.setText(desc)
        dialog.edtdialogqty.setText(qty.toString())
        dialog.edtdialogprice.setText(price.toString())
        dialog.btndialogupdate.setOnClickListener {
            var id = dialog.txtid.text.toString().toInt()
            var name = dialog.edtdialogname.text.toString()
            var desc = dialog.edtdialogdesc.text.toString()
            var qty = dialog.edtdialogqty.text.toString().toInt()
            var price = dialog.edtdialogprice.text.toString().toInt()
            var fruit = Fruit(id,name,desc,qty,price)
            var flag = db.Update(fruit)
            if(flag)
            {
                Toast.makeText(this, "Record Updated", Toast.LENGTH_LONG).show()
                dialog.dismiss()
                updateRecuclerview()
            }
        }
        dialog.show()

    }
    public fun invoice(position:Int){
        var db = DBHelper(this)
        var arr = db.retriveall()
        var fruit = arr.get(position)
        var id = fruit.id
        var name = fruit.fr_name
        var desc = fruit.fr_desc
        var qty = fruit.fr_qty
        var price = fruit.fr_price
        var amount = qty * price
        var invoice = Dialog(this)
        invoice.setContentView(R.layout.invoice_dialog_layout)
        invoice.txtinvoiceid.setText(id.toString())
        invoice.txtinvoicename.setText(name)
        invoice.txtinvoicedesc.setText(desc)
        invoice.txtinvoiceqty.setText(qty.toString())
        invoice.txtinvoiceprice.setText(price.toString())
        invoice.txtinvoiceamount.setText(amount.toString())
        invoice.show()
    }

    private fun updateRecuclerview()
    {
        var db = DBHelper(this)
        var arr = db.retriveall()
        var fruitadapter = MyAdapter(this,arr)
        myrecycle.adapter = fruitadapter

    }
}