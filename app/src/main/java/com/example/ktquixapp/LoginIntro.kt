package com.example.ktquixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)

        // if user is already logged in
        val auth = FirebaseAuth.getInstance()
        if(auth.currentUser != null) {
            Toast.makeText(this, "Already logged in..", Toast.LENGTH_SHORT).show()
            redirect("MAIN")
        }

        // if user is not logged in, first time visitors
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