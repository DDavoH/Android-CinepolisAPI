package com.davoh.cinepolisapi.presentation.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.davoh.cinepolisapi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {
    
    fun configToolbar(toolbar: Toolbar) {
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        toolbar.setupWithNavController(findNavController(), appBarConfiguration)
    }
    
    fun titleFragment(title:String, tvTitle: TextView){
        tvTitle.text = title
    }
    
    fun showLoader(isLoading : Boolean){
        requireActivity().findViewById<View>(R.id.loader).visibility = if (isLoading) View.VISIBLE else View.INVISIBLE
    }

}