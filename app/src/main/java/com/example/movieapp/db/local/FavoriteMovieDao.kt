package com.example.movieapp.db.local

import androidx.room.*
import com.example.movieapp.model.Favorite
import com.example.movieapp.model.Movie

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavMovie(favorite: Favorite)

    @Query("SELECT * FROM favorite_table WHERE id LIKE :id")
    suspend fun getFavoriteMovieById(id:Int): Favorite

    @Query("SELECT * FROM favorite_table")
    suspend fun getAllFavoriteMovie(): List<Favorite>

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}