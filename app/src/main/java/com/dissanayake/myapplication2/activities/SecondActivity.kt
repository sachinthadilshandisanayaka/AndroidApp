package com.dissanayake.myapplication2.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dissanayake.myapplication2.R
import com.dissanayake.myapplication2.showToast
import kotlinx.android.synthetic.main.activity_second.*

// inherit
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // append layout
        setContentView(R.layout.activity_second)
        val bundle : Bundle? = intent.extras
        bundle?.let {
            val message = it.getString("user_message")
            showToast(message.toString())
            textUserMessage.text = message
        }
    }
}