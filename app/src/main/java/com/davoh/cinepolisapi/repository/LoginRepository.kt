package com.davoh.cinepolisapi.repository

import com.davoh.cinepolisapi.data.SessionData
import com.davoh.cinepolisapi.framework.retrofit.ApiService
import com.davoh.cinepolisapi.framework.retrofit.responses.LoginResponse
import com.davoh.cinepolisapi.framework.sharedPreferences.SessionPreferences
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    private val sessionPreferences: SessionPreferences) {
    
    fun login(userName:String, password:String) : Observable<LoginResponse>{
        return apiService.login(
            "stage_HNYh3RaK_Test","MX", userName, password, "password", "IATestCandidate", "c840457e777b4fee9b510fbcd4985b68"
        ).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
    }
    
    fun saveSession(session: SessionData){
        return sessionPreferences.saveSession(session)
    }
    
    fun deleteSession(){
        return sessionPreferences.cleanSession()
    }
    
}