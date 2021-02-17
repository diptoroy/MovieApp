package com.example.movieapp.db.remote

import com.example.movieapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("?i=tt3896198&apikey=f90450a3")
    suspend fun getMovie(): Response<Movie>

    @GET("diptoroy/1ea1263971042e410af6c2cf220e4691/raw/3a6f837bd0e32fccbd2ba35829b84641ab0f6b06/movie%2520db%2520demo")
    suspend fun getAllMovie(): List<Movie>

    @GET("diptoroy/1ea1263971042e410af6c2cf220e4691/raw/478cf7d7398e90df7c4f39d127c93bd559f2969d/movie%2520db%2520demo")
    suspend fun getAllMovieList(): Response<List<Movie>>

}