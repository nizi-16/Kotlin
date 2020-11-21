package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

           // get reference to button
        val btnClickMe = findViewById(R.id.button) as Button
        // reference to the text
        val myTextView=findViewById(R.id.textView) as TextView
        var timesClicked=0
          // set on-click listener
        btnClickMe.setOnClickListener {
            timesClicked=timesClicked+1
            myTextView.text=timesClicked.toString()
            Toast.makeText(this@MainActivity, "Clicking done right", Toast.LENGTH_SHORT).show()
        }
    }
}