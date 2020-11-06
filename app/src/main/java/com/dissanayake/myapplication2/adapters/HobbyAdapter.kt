package com.dissanayake.myapplication2.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dissanayake.myapplication2.Hobby
import com.dissanayake.myapplication2.R
import kotlinx.android.synthetic.main.list_item.view.*


class HobbyAdapter(val context: Context, val hobbies : List<Hobby>): RecyclerView.Adapter<HobbyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }
    // one item is a view holder
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var currentPosition: Int = 0
        var currentHobby: Hobby? = null

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHobby!!.title+ " Clicked !", Toast.LENGTH_SHORT).show()
            }
            itemView.imgShare.setOnClickListener {
                val message : String = "My hobby is : " + currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, "Share to :"))
            }
        }

        fun setData(hobby : Hobby, pos: Int) {
            itemView.textTitle.text = hobby!!.title
            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}














