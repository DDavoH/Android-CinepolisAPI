package com.davoh.cinepolisapi.repository

import com.davoh.cinepolisapi.data.SessionData
import com.davoh.cinepolisapi.framework.retrofit.ApiService
import com.davoh.cinepolisapi.framework.retrofit.responses.MovieResponse
import com.davoh.cinepolisapi.framework.retrofit.responses.MoviesResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService,
    private val sessionData: SessionData
    ) {

    fun getMovies(): Observable<MoviesResponse>{
        return apiService.getMovies("stage_HNYh3RaK_Test", sessionData.countryCode, 4)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

}