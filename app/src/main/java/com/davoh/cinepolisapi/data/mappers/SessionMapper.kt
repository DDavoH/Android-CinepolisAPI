package com.davoh.cinepolisapi.framework.room.session

import com.davoh.cinepolisapi.data.SessionData
import com.davoh.cinepolisapi.framework.retrofit.responses.LoginResponse


fun LoginResponse.toSessionData() : SessionData {
    return SessionData(
        accessToken = this.accessToken?:"",
        tokenType = this.tokenType?:"",
        clientId = this.clientId?:"",
        userName = this.username?:"",
        countryCode = this.countryCode?:""
    )
}