package com.davoh.cinepolisapi.presentation.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davoh.cinepolisapi.R
import com.davoh.cinepolisapi.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        listenView()
    }
    
    private fun listenView(){
        binding.btnLogin.setOnClickListener {
        
        }
    }
}