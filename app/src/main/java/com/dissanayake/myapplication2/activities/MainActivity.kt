package com.dissanayake.myapplication2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dissanayake.myapplication2.R
import com.dissanayake.myapplication2.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R is predefine class
        // attach layout to the main Activity
        setContentView(R.layout.activity_main)

        futureButton.setOnClickListener {
            // code
            // we can see this msg in cmd as MainActivity child msg
            Log.i("MainActivity", "Future is near")

            // show message in the screen
            showToast("Future is near")
        }
        btnSendMessage.setOnClickListener {
            val message : String = edUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }
        btnShareData.setOnClickListener {
            val message : String = edUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to :"))
        }
        btnListView.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}