package com.davoh.cinepolisapi.framework.retrofit.responses

import com.google.gson.annotations.SerializedName

data class ProfileResponse (
    @SerializedName("email"           ) var email          : String? = null,
    @SerializedName("first_name"      ) var firstName      : String? = null,
    @SerializedName("last_name"       ) var lastName       : String? = null,
    @SerializedName("phone_number"    ) var phoneNumber    : String? = null,
    @SerializedName("profile_picture" ) var profilePicture : String? = null,
    @SerializedName("card_number"     ) var cardNumber     : String? = null
)