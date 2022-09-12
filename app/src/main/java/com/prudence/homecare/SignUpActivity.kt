package com.prudence.homecare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.prudence.homecare.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        validationSignup()
    }


    fun validationSignup() {
        var error = false
        binding.tilFirstName.error = null
        binding.tilLastName.error = null
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        binding.tilconfirmPassword.error = null

        var firstname = binding.etFirstName.text.toString()
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        }
        var lastname = binding.etLastName.text.toString()
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        }
        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Not valid email address"
            error = true

        }
        var password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true

        }
        var confirm = binding.etConfirmPassword.text.toString()
        if (confirm.isBlank()) {
            binding.tilconfirmPassword.error = "Invalid password,enter password"
            error = true
        }
        if (password != confirm) {
            binding.tilconfirmPassword.error = "Enter password"
        }
        if (error != false) {
        }
    }
}