package com.davoh.cinepolisapi.presentation.utils

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.davoh.cinepolisapi.R


open class BaseActivity : AppCompatActivity() {
    
    fun showLoader(isLoading : Boolean){
       findViewById<View>(R.id.loader).setVisibility(if (isLoading) View.VISIBLE else View.INVISIBLE)
    }
    
    
}