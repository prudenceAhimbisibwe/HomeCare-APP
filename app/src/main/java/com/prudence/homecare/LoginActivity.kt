package com.prudence.homecare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.prudence.homecare.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvsignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogin.setOnClickListener {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        validation()
    }

    fun validation() {
        var error = false
        binding.tilemail.error = null
        binding.tilpassword.error = null


        var email = binding.etemail.text.toString()
        if (email.isBlank()) {
            binding.tilemail.error = "Email is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilemail.error = "Not valid email address"
            error = true
        }

        var password = binding.etpassword.text.toString()
        if (password.isBlank()) {
            binding.tilpassword.error = "Password is required"
            error = true
        }
        if (error!=false) {

        }
    }
}



