package com.ramos.franco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramos.franco.databinding.ActivityLoginBinding
import com.ramos.franco.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fabAddCodigo.setOnClickListener{
            val intent = Intent(this , AddCodigoActivity::class.java)
            startActivity(intent)
        }


    }
}