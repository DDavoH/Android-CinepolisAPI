package com.davoh.cinepolisapi.presentation.movies

import androidx.lifecycle.MutableLiveData
import com.davoh.cinepolisapi.framework.retrofit.responses.MovieResponse
import com.davoh.cinepolisapi.framework.retrofit.responses.MoviesResponse
import com.davoh.cinepolisapi.presentation.utils.BaseViewModel
import com.davoh.cinepolisapi.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieRepository: MovieRepository) : BaseViewModel() {

    val movies = MutableLiveData<MoviesResponse>()
    
    fun getMovies(){
        movieRepository.getMovies().doOnSubscribe { isLoading.postValue(true) }
            .subscribe({
                movies.postValue(it)
                isLoading.postValue(false)
            },{
                isLoading.postValue(false)
            })
    }

}