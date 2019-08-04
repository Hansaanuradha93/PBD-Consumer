package com.example.hansaanuradha.consumer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sendButton = findViewById<Button>(R.id.sendButton)
        val inputText = findViewById<EditText>(R.id.wholeNumberEditText)

        // Onclick listener
        sendButton.setOnClickListener {
            Log.d("hello", "hello")
            //Log.i("Whole Number", inputText.text.toString())
        }
    }

    fun send(view: View) {
        Log.i("Test", "It's working")
    }
}
