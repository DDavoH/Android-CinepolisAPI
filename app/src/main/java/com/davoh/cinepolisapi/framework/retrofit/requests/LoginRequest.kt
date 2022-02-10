package com.davoh.cinepolisapi.framework.retrofit.requests

import retrofit2.http.Field

data class LoginRequest(
    @Field("country_code") val countryCode:String,
    @Field("username") val userName:String,
    @Field("password") val password : String,
    @Field("grant_type") val grantType :String,
    @Field("client_id") val clientId : String,
    @Field("client_secret") val clientSecret : String
    )