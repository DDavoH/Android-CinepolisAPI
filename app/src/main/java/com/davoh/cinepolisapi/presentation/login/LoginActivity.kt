package com.davoh.cinepolisapi.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.davoh.cinepolisapi.R
import com.davoh.cinepolisapi.databinding.ActivityLoginBinding
import com.davoh.cinepolisapi.presentation.home.HomeActivity
import com.davoh.cinepolisapi.presentation.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    
    private lateinit var binding : ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        listenView()
        observables()
    }
    
    private fun listenView(){
        binding.btnLogin.setOnClickListener {
            viewModel.login(binding.etEmailInput.text.toString(), binding.etPasswordInput.text.toString())
        }
    }
    
    private fun observables(){
        viewModel.loginSuccess.observe(this, {succes->
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })
        viewModel.isLoading.observe(this, this::showLoader)
    }
}