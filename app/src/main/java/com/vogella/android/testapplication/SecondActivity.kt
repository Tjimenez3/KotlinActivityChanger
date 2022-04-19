package com.vogella.android.testapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println("Overriding onCreate Activity 2")

        val textView = findViewById<TextView>(R.id.returnTextView)
        textView.text = intent?.extras?.getString("Email")


    }
    override fun onStart() {
        super.onStart()
        println("Overriding onStart Activity 2")
    }
    override fun onResume() {
        super.onResume()
        println("Overriding onResume Activity 2")

    }
    override fun onStop() {
        super.onStop()
        println("Overriding onStop Activity 2")

    }
    override fun onDestroy(){
        super.onDestroy()
        println("Overriding onDestroy Activity 2")
    }
}