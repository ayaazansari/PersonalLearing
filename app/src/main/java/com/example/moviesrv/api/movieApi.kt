package com.example.moviesrv.api

import com.example.moviesrv.models.Movie
import retrofit2.Response
import retrofit2.http.GET

interface movieApi {

    @GET("/api/movies")
    suspend fun getMovies(): Response<List<Movie>>
}