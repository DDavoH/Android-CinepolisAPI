package com.davoh.cinepolisapi.data

import com.davoh.cinepolisapi.framework.retrofit.responses.Cast
import com.davoh.cinepolisapi.framework.retrofit.responses.Media

data class Movie(
    var rating: String,
    var media: ArrayList<Media> = arrayListOf(),
    var cast: ArrayList<Cast> = arrayListOf(),
    var cinemas: ArrayList<String> = arrayListOf(),
    val position: Int,
    val categories: ArrayList<String> = arrayListOf(),
    var genre: String,
    var synopsis: String,
    var length: String,
    var releaseDate: String,
    var distributor: String,
    var id: Int,
    var name: String,
    var code: String,
    var originalName: String,
    val image:String
)