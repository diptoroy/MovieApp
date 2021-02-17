package com.example.movieapp.db.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieapp.model.Actor
import com.example.movieapp.model.Converter
import com.example.movieapp.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
    abstract fun getFavoriteMovieDao(): FavoriteMovieDao

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: buildDatabase(context).also {
                        instance = it
                    }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movieDatabase"
        ).build()

    }
}