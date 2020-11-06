package com.dissanayake.myapplication2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dissanayake.myapplication2.adapters.HobbyAdapter
import com.dissanayake.myapplication2.R
import com.dissanayake.myapplication2.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setUpRecycleView()
    }

    private fun setUpRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = layoutManager

        val adapter = HobbyAdapter(this, Supplier.hobbies)
        recycleView.adapter = adapter
    }
}
