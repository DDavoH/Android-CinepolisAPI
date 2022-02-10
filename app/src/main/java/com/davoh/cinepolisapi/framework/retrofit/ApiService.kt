package com.davoh.cinepolisapi.framework.retrofit

import com.davoh.cinepolisapi.framework.retrofit.responses.LoginResponse
import com.davoh.cinepolisapi.framework.retrofit.responses.ProfileResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface ApiService {

    @POST("v2/oauth/token")
    @FormUrlEncoded
    fun login(
                @Header("api_key") apiKey:String,
                @Field("country_code")  countryCode:String,
              @Field("username")  userName:String,
              @Field("password")  password : String,
              @Field("grant_type")  grantType :String,
              @Field("client_id")  clientId : String,
              @Field("client_secret")  clientSecret : String): Observable<LoginResponse>
    
    @GET("v1/members/profile")
    @FormUrlEncoded
    fun getProfile(
        @Header("api_key") apiKey: String,
        @Header("authorization") token:String,
        @Query("country_code") countryCode: String
    ) : Observable<ProfileResponse>

}