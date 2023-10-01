package com.example.moviesrv.repository

import com.example.moviesrv.api.RetrofitInstance

class MovieRepository {
    suspend fun getAllMovies() = RetrofitInstance.api.getMovies()
}