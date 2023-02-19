package com.example.ktquixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        var btnLogIn = findViewById<Button>(R.id.btnLogIn)
        btnLogIn.setOnClickListener {
            logInUser()
        }

        var btnSignUp = findViewById<TextView>(R.id.btnSignup)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity:: class.java)
            startActivity(intent)
        }
    }

    // signUpUser func
    private fun logInUser() {
        var email = findViewById<EditText>(R.id.etEmail).text.toString()
        var password = findViewById<EditText>(R.id.etPassword).text.toString()

        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Email/password cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Log In Success", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
