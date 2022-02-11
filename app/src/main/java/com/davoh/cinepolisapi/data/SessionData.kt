package com.davoh.cinepolisapi.data


data class SessionData (
    val accessToken : String,
    val tokenType: String,
    val clientId: String,
    val userName:String,
    val countryCode:String,
        )