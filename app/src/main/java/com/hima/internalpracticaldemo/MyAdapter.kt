package com.hima.internalpracticaldemo
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_item.view.*

class MyAdapter (val context:Context,var arr:ArrayList<Fruit>)
    :RecyclerView.Adapter<MyAdapter.FruitViewHolde>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolde {
        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.card_item,parent,false)
        return FruitViewHolde(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolde, position: Int) {
        holder.bind(arr[position])
        holder.view.btndelete.setOnClickListener {
            if (context is ViewAll) {
                context.delete(position)
            }
        }
        holder.view.btnupdate.setOnClickListener {
            if (context is ViewAll) {
                context.update(position)
            }
        }
        holder.view.imginvoice.setOnClickListener {
        if (context is ViewAll) {
            context.invoice(position)
        }
    }

    }

    override fun getItemCount(): Int {
        return  arr.size
    }

    class FruitViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(f:Fruit)
        {

            view.tvfrname.setText(f.fr_name)
            view.tvfrdesc.setText(f.fr_desc)
            view.tvfrqty.setText(f.fr_qty.toString())
            view.tvfrprice.setText(f.fr_price.toString())

        }
    }
}