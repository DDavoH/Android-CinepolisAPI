package com.davoh.cinepolisapi.data.mappers

import com.davoh.cinepolisapi.data.Movie
import com.davoh.cinepolisapi.framework.retrofit.responses.Media
import com.davoh.cinepolisapi.framework.retrofit.responses.MoviesResponse
import com.davoh.cinepolisapi.framework.retrofit.responses.Routes
import com.davoh.cinepolisapi.framework.retrofit.responses.Sizes
import timber.log.Timber

fun MoviesResponse.toMovieList() : List<Movie> {
    val returnedList = mutableListOf<Movie>()
    
    this.movies.forEach {
        returnedList.add(Movie(
            rating = it.rating?:"",
            media = it.media,
            cast = it.cast,
            cinemas = it.cinemas,
            position = it.position?:0,
            categories = it.categories,
            genre = it.genre?:"",
            synopsis = it.synopsis?:"",
            length = it.length ?:"",
            releaseDate = it.releaseDate ?:"",
            distributor = it.distributor ?:"",
            id = it.id ?:0,
            name = it.name?:"",
            code = it.code?:"",
            originalName = it.originalName?:"",
            image = this.routes.getImageRoute() + it.media.getImageMedia()
        ))
    }
    return returnedList
}

fun List<Routes>.getImageRoute(): String {
    var returnedValue = ""
    this.forEach {  route->
        if(route.code == "poster"){
            returnedValue = route.sizes?.getMediumSize()?:""
        }
    }
    return returnedValue
}

fun Sizes.getMediumSize() : String {
    return this.medium?:""
}

fun List<Media>.getImageMedia() : String {
    var returnedValue = ""
    this.forEach {
        println("Image resource: " + it.resource)
        if(it.code == "poster"){
            println("Image resource: " + it.resource)
            returnedValue = it.resource?:""
        }
    }
    return returnedValue
}