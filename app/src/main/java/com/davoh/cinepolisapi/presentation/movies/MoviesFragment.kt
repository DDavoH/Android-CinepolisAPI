package com.davoh.cinepolisapi.presentation.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.davoh.cinepolisapi.R
import com.davoh.cinepolisapi.databinding.FragmentMoviesBinding
import com.davoh.cinepolisapi.presentation.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment() {
    
    
    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding : FragmentMoviesBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater,container, false)
        configToolbar(binding.toolbarInclude.toolbar)
        titleFragment(getString(R.string.cartelera), binding.toolbarInclude.toolbarTitle)
    
    
        return binding.root
    }
    
}