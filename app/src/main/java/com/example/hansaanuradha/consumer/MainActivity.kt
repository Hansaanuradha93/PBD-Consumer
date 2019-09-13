package com.example.hansaanuradha.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Views for one number input
        val sendButton = findViewById<Button>(R.id.sendButton)
        val inputText = findViewById<EditText>(R.id.wholeNumberEditText)

        // Views for multiple numbers input
        val commaSeparatedEditText = findViewById<EditText>(R.id.comaSeparatedWholeNumbersEditText)
        val sendNumbersButton = findViewById<Button>(R.id.sendNumbersButton)

        // Onclick listener for sendButton
        sendButton.setOnClickListener {

            // Get the input number value
            val numberString = inputText.getText().toString()

            // Check whether text box is not empty
            if (!numberString.isNullOrEmpty()) {
                // Send the data to the Producer application
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra("SingleNumber", numberString)
                sendIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendIntent, resources.getText(R.string.send_to)))
            } else {
                Toast.makeText(this, "Text Field is Empty", Toast.LENGTH_SHORT).show()
            }

        }

        // Onclick listener for sendNumbersButton
        sendNumbersButton.setOnClickListener {

            // Get the comma separated input
            val numbersString = commaSeparatedEditText.getText().toString()

            // Check whether text box is not empty
            if (!numbersString.isNullOrEmpty()) {
                // Send the data to the Producer application
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra("MultipleNumbers", numbersString)
                sendIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendIntent, resources.getText(R.string.send_to)))
            } else {
                Toast.makeText(this, "Text Field is Empty", Toast.LENGTH_SHORT).show()
            }

        }


    }

}
