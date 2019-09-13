package com.example.hansaanuradha.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Views for one number input
        val sendButton = findViewById<Button>(R.id.sendButton)
        val inputText = findViewById<EditText>(R.id.wholeNumberEditText)

        // Views for multiple numbers input
        val comaSeparatedEditText = findViewById<EditText>(R.id.comaSeparatedWholeNumbersEditText)
        val sendNumbersButton = findViewById<Button>(R.id.sendNumbersButton)

        // Onclick listeners
        sendButton.setOnClickListener {

            val numberString = inputText.getText().toString()

            if (!numberString.isNullOrEmpty()) {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra("SingleNumber", numberString)
                sendIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendIntent, resources.getText(R.string.send_to)))
            } else {
                Toast.makeText(this, "Text Field is Empty", Toast.LENGTH_SHORT).show()
            }

        }

        sendNumbersButton.setOnClickListener {
            Log.v("Numbers", comaSeparatedEditText.getText().toString())

            val numbersString = comaSeparatedEditText.getText().toString()

            if (!numbersString.isNullOrEmpty()) {

                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra("MultipleNumbers", numbersString)
                sendIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendIntent, resources.getText(R.string.send_to)))
            } else {
                Toast.makeText(this, "Text Field is Empty", Toast.LENGTH_SHORT).show()
            }

        }


        // TODO: - Pass this as a whole string to Producer, then split it, Get the result and convert it into a String in the Producer, Then send it back to the Consumer

    }

}
