package com.dissanayake.myapplication2.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dissanayake.myapplication2.models.Hobby
import com.dissanayake.myapplication2.R
import com.dissanayake.myapplication2.showToast
import kotlinx.android.synthetic.main.list_item.view.*


class HobbyAdapter(val context: Context, private val hobbies : List<Hobby>): RecyclerView.Adapter<HobbyAdapter.MyViewHolder>(){
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
                currentHobby?.let {
                    // Toast function in "Activity" method.
                    // But this function in "Adapter" class
                    // So, we need to convert adapter to Action
                    context.showToast(it.title+ " Clicked !")
                    Toast.makeText(context, it.title+ " Clicked !", Toast.LENGTH_SHORT).show()
                }
            }
            itemView.imgShare.setOnClickListener {
                currentHobby?.let {
                    val message : String = "My hobby is : " + it.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Share to :"))
                }
            }
        }

        fun setData(hobby : Hobby, pos: Int) {
            hobby?.let {
                itemView.textTitle.text = it.title
                this.currentHobby = it
                this.currentPosition = pos
            }
        }
    }
}
