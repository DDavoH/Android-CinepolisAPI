package com.davoh.cinepolisapi.presentation.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davoh.cinepolisapi.R
import com.davoh.cinepolisapi.data.Movie
import com.davoh.cinepolisapi.data.mappers.toMovieList
import com.davoh.cinepolisapi.databinding.FragmentMoviesBinding
import com.davoh.cinepolisapi.presentation.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment() {
    
    
    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding : FragmentMoviesBinding
    private lateinit var moviesAdapter : MovieAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater,container, false)
        configToolbar(binding.toolbarInclude.toolbar)
        titleFragment(getString(R.string.cartelera), binding.toolbarInclude.toolbarTitle)
        
        configView()
        observables()
    
        return binding.root
    }
    
    private fun configView(){
        binding.rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        moviesAdapter = MovieAdapter()
        binding.rv.adapter = moviesAdapter
    }
    
    private fun observables(){
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, {movies->
            moviesAdapter.submitList(movies.toMovieList())
        })
        viewModel.isLoading.observe(viewLifecycleOwner, this::showLoader)
    }
    
}