package com.dissanayake.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
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
            Toast.makeText(this, "Future is near", Toast.LENGTH_SHORT).show()
        }
        btnSendMessage.setOnClickListener {
            val message : String = edUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }
    }
}











