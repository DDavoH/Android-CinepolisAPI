package com.davoh.cinepolisapi.framework.retrofit.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("access_token"  ) var accessToken  : String? = null,
    @SerializedName("token_type"    ) var tokenType    : String? = null,
    @SerializedName("expires_in"    ) var expiresIn    : Int?    = null,
    @SerializedName("refresh_token" ) var refreshToken : String? = null,
    @SerializedName("as:client_id"  ) var clientId  : String? = null,
    @SerializedName("username"      ) var username     : String? = null,
    @SerializedName("country_code"  ) var countryCode  : String? = null,
    @SerializedName(".issued"       ) var issued      : String? = null,
    @SerializedName(".expires"      ) var expires     : String? = null
)