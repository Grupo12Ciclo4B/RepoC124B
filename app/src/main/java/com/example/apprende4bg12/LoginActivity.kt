package com.example.apprende4bg12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.apprende4bg12.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val password = findViewById<Button>(R.id.pass)

        password.setOnClickListener{
            val intent = Intent(this, PasswordReset::class.java)
            startActivity(intent)
        }

        val signup = findViewById<Button>(R.id.signupbtn)

        signup.setOnClickListener{
            val intent2 = Intent(this, SignupActivity::class.java)
            startActivity(intent2)
        }

    }
}