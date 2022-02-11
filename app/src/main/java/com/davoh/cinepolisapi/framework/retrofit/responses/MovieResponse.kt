package com.davoh.cinepolisapi.framework.retrofit.responses

import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("movies" ) var movies : ArrayList<MovieResponse> = arrayListOf(),
    @SerializedName("routes" ) var routes : ArrayList<Routes> = arrayListOf()
        )

data class MovieResponse (
    
    @SerializedName("rating"        ) var rating       : String?           = null,
    @SerializedName("media"         ) var media        : ArrayList<Media>  = arrayListOf(),
    @SerializedName("cast"          ) var cast         : ArrayList<Cast>   = arrayListOf(),
    @SerializedName("cinemas"       ) var cinemas      : ArrayList<String> = arrayListOf(),
    @SerializedName("position"      ) var position     : Int?              = null,
    @SerializedName("categories"    ) var categories   : ArrayList<String> = arrayListOf(),
    @SerializedName("genre"         ) var genre        : String?           = null,
    @SerializedName("synopsis"      ) var synopsis     : String?           = null,
    @SerializedName("length"        ) var length       : String?           = null,
    @SerializedName("release_date"  ) var releaseDate  : String?           = null,
    @SerializedName("distributor"   ) var distributor  : String?           = null,
    @SerializedName("id"            ) var id           : Int?              = null,
    @SerializedName("name"          ) var name         : String?           = null,
    @SerializedName("code"          ) var code         : String?           = null,
    @SerializedName("original_name" ) var originalName : String?           = null

)

data class Media (
    
    @SerializedName("resource" ) var resource : String? = null,
    @SerializedName("type"     ) var type     : String? = null,
    @SerializedName("code"     ) var code     : String? = null

)

data class Cast (
    
    @SerializedName("label" ) var label : String?           = null,
    @SerializedName("value" ) var value : ArrayList<String> = arrayListOf()

)

data class Routes (
    
    @SerializedName("code"  ) var code  : String? = null,
    @SerializedName("sizes" ) var sizes : Sizes?  = Sizes()

)

data class Sizes (
    
    @SerializedName("large"   ) var large   : String? = null,
    @SerializedName("medium"  ) var medium  : String? = null,
    @SerializedName("small"   ) var small   : String? = null,
    @SerializedName("x-large" ) var xLarge : String? = null

)