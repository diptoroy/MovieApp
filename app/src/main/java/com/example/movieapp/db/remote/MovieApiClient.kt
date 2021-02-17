package com.example.movieapp.db.remote

import com.example.movieapp.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieApiClient {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieApi: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }
}