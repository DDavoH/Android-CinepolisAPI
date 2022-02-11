package com.davoh.cinepolisapi.framework.sharedPreferences

import android.content.Context
import com.davoh.cinepolisapi.data.SessionData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionPreferences @Inject constructor(@ApplicationContext context: Context) {
    
    val sharedPref = context.getSharedPreferences("session_shared_prefs",Context.MODE_PRIVATE)
    
    fun saveSession(session: SessionData){
        with (sharedPref.edit()) {
            putString("access_token", session.accessToken)
            putString("token_type", session.tokenType)
            putString("client_id", session.clientId)
            putString("username", session.userName)
            putString("country_code", session.countryCode)
            apply()
        }
    }
    
    fun getSession(): SessionData {
        val accessToken = sharedPref.getString("access_token","")
        val tokenType = sharedPref.getString("token_type","")
        val clientId =sharedPref.getString("client_id","")
        val userName = sharedPref.getString("username","")
        val countryCode = sharedPref.getString("country_code","")
        return SessionData(accessToken?:"", tokenType?:"", clientId?:"", userName?:"", countryCode?:"")
    }
    
    
    fun cleanSession() {
        with (sharedPref.edit()) {
            putString("access_token", "")
            putString("token_type", "")
            putString("client_id", "")
            putString("username", "")
            putString("country_code", "")
            apply()
        }
    }
}