package com.example.ktquixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        firebaseAuth = FirebaseAuth.getInstance()
        var btnSignUp = findViewById<Button>(R.id.btnSignup)
        btnSignUp.setOnClickListener {
            signUpUser()
        }

        var btnLogIn = findViewById<TextView>(R.id.btnLogin)
        btnLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
            finish()
        }
    }

    // signUpUser func
    private fun signUpUser(){
        var email = findViewById<EditText>(R.id.etEmail).text.toString()
        var password = findViewById<EditText>(R.id.etPassword).text.toString()
        var confirmPassword = findViewById<EditText>(R.id.etConfirmPassword).text.toString()

        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    // on success registration code
                    Toast.makeText(this,"Sign Up Successful", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "Error creating user.", Toast.LENGTH_LONG).show()
                }
            }
    }


}