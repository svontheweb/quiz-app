package com.example.ktquixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)

        var btnGetStarted = findViewById<Button>(R.id.button)
        btnGetStarted.setOnClickListener {
            redirect("LOGIN")
        }
    }

    private fun redirect(name: String) {
        val intent = when(name) {
            "LOGIN" -> Intent(this, LoginActivity:: class.java)
            "MAIN" -> Intent(this, MainActivity:: class.java)
            else -> throw Exception("no path exists")
        }

        startActivity(intent)
        finish()
    }
}