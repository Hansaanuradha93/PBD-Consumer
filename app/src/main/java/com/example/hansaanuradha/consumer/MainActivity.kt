package com.example.hansaanuradha.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sendButton = findViewById<Button>(R.id.sendButton)
        val inputText = findViewById<EditText>(R.id.wholeNumberEditText)
//        val resultText = findViewById<TextView>(R.id.resultTextView)

        // Lets try to get the intent object
//        if (intent != null) {
//            when {
//                intent?.action == Intent.ACTION_SEND -> {
//                    if ("text/plain" == intent.type) {
//                        handleSendText(intent) // Handle text being sent
//                    }
//                }
//                else -> {
//                    // Handle other intents, such as being started from the home screen
//                }
//            }
//        }



        // Onclick listener
        sendButton.setOnClickListener {
            Log.d("hello", "hello")
            Log.v("EditText", inputText.getText().toString())

            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, inputText.getText().toString())
            sendIntent.type = "text/plain"
            startActivity(Intent.createChooser(sendIntent, resources.getText(R.string.send_to)))


        }
    }

    private fun handleSendText(intent: Intent) {
        val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
        if (sharedText != null) {
            resultTextView.setText(sharedText)
        }
    }

}
