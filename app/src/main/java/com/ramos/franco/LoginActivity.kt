package com.ramos.franco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.ramos.franco.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupviews()
    }
    private fun setupviews(){
        binding.tilEmail.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled=validateInputs(text.toString(), binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled=validateInputs(binding.tilEmail.editText?.text.toString(),text.toString())

        }
        binding.btnLogin.setOnClickListener{
           val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()

        }

    }


     private fun validateInputs(email: String,password: String): Boolean {
         val isEmailOk= email.equals("ejemplo@gmail.com")
         val isPasswordOk= password.equals("123456")

         return isPasswordOk && isEmailOk
     }
}