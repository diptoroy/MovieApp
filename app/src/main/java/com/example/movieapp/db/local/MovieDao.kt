package com.example.movieapp.db.local

import androidx.room.*
import com.example.movieapp.model.Favorite
import com.example.movieapp.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    //All Movie
    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovieDB(): List<Movie>

    @Update
    suspend fun movieUpdate(movie: Movie)

    @Delete
    suspend fun movieDelete(movie: Movie)

    //Search Query
    @Query("SELECT * FROM movie_table WHERE title LIKE :title")
    suspend fun getSearchMovieDB(title: String): List<Movie>


}