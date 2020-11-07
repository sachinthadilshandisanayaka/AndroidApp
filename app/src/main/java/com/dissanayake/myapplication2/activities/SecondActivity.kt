package com.dissanayake.myapplication2.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dissanayake.myapplication2.AppConstant
import com.dissanayake.myapplication2.R
import com.dissanayake.myapplication2.showToast
import kotlinx.android.synthetic.main.activity_second.*

// inherit
class SecondActivity : AppCompatActivity() {

    companion object {
        // this return "SecondActivity" string
        val TAG:String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // append layout
        setContentView(R.layout.activity_second)
        val bundle : Bundle? = intent.extras
        bundle?.let {
            val message = it.getString(AppConstant.USER_MSG_KEY)
            showToast(message.toString())
            textUserMessage.text = message
        }
    }
}