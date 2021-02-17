package com.example.movieapp.db.repository

import android.content.Context
import com.example.movieapp.db.local.FavoriteMovieDao
import com.example.movieapp.db.local.MovieDao
import com.example.movieapp.db.local.MovieDatabase
import com.example.movieapp.db.remote.MovieApi
import com.example.movieapp.db.remote.MovieApiClient
import com.example.movieapp.model.Favorite
import com.example.movieapp.model.Movie
import retrofit2.Response

class Repository(context: Context) {

//    suspend fun getAllMovieList():Response<List<Movie>>{
//        return MovieApiClient.movieApi.getAllMovieList()
//    }

    private val movieDao: MovieDao = MovieDatabase.invoke(context).getMovieDao()
    private val favoriteMovieDao: FavoriteMovieDao = MovieDatabase.invoke(context).getFavoriteMovieDao()
    private val movieCall = MovieApiClient.movieApi

    //MovieDao
    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }
    suspend fun searchData(title: String): List<Movie> {
        return movieDao.getSearchMovieDB(title)
    }
    suspend fun getAllMovieDB(): List<Movie> {
        return movieDao.getAllMovieDB().also {
            getAllMovieFromServer()
        }
    }
    private suspend fun getAllMovieFromServer() {
        try {
            val movieList = movieCall.getAllMovie()
            movieList.forEach {
                insertMovie(it)
            }
        } catch (exception: Throwable) {
        }
    }

    suspend fun insertFavMovie(favorite: Favorite){
        favoriteMovieDao.insertFavMovie(favorite)
    }

}