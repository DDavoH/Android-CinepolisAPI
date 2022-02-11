package com.davoh.cinepolisapi.repository

import com.davoh.cinepolisapi.framework.retrofit.ApiService
import com.davoh.cinepolisapi.framework.retrofit.responses.ProfileResponse
import com.davoh.cinepolisapi.data.SessionData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val apiService: ApiService,
    private val sessionData: SessionData
)  {
    
     fun getProfile(): Observable<ProfileResponse> {
            return apiService.getProfile("stage_HNYh3RaK_Test","Bearer " + sessionData.accessToken,sessionData.countryCode).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
    
}