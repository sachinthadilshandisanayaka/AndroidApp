package com.dissanayake.myapplication2.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dissanayake.myapplication2.R
import kotlinx.android.synthetic.main.activity_second.*

// inherit
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // append layout
        setContentView(R.layout.activity_second)
        val bundle : Bundle? = intent.extras
        val message = bundle!!.getString("user_message")
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

        textUserMessage.text = message
    }
}