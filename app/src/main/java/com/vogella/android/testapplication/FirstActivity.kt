package com.vogella.android.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.regex.Pattern

class FirstActivity : AppCompatActivity() {


    private val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})".toRegex()

    private fun isEmail(email: String): Boolean{
        return EMAIL_REGEX.matches(email)
    }
    private fun passwordLengthCheck(password: String): Boolean {
        return password.length >=6
    }
    private fun setEmailError(emailEditTextView: EditText) {
        emailEditTextView.error = "Enter a correct email address"

    }
    private fun setPasswordError(passwordEditTextView: EditText) {
        passwordEditTextView.error = "Your password must be at least 6 characters long"

    }
    private fun login(intent: Intent) {

        val emailEditTextView = findViewById<EditText>(R.id.emailEditText)
        val passwordEditTextView = findViewById<EditText>(R.id.passwordEditText)

        emailEditTextView.selectAll()
        passwordEditTextView.selectAll()
        var emailEditText = emailEditTextView?.text.toString()
        var passwordEditText = passwordEditTextView?.text.toString()

        intent.putExtra("Email",emailEditText)
        intent.putExtra("Password",passwordEditText)

        if (!isEmail(emailEditText)) {
            setEmailError(emailEditTextView)
        }
        else if(!passwordLengthCheck(passwordEditText)) {
            setPasswordError(passwordEditTextView)
        }
        else {
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        println("Overriding onCreate Activity 1")

        val btnSecondActivity = findViewById<Button>(R.id.btnSecondActivity)

        btnSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            login(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        println("Overriding onStart Activity 1")
    }
    override fun onResume() {
        super.onResume()
        println("Overriding onResume Activity 1")

    }
    override fun onStop() {
        super.onStop()
        println("Overriding onStop Activity 1")

    }
    override fun onDestroy(){
        super.onDestroy()
        println("Overriding onDestroy Activity 1")
    }
}