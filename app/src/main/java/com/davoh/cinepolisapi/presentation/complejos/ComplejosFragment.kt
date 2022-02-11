package com.davoh.cinepolisapi.presentation.complejos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.davoh.cinepolisapi.R
import com.davoh.cinepolisapi.databinding.FragmentComplejosBinding

class ComplejosFragment : Fragment() {
    
    private val viewModel: ComplejosViewModel by viewModels()
    private lateinit var binding : FragmentComplejosBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComplejosBinding.inflate(inflater, container, false)
        return binding.root
        }
    
}