package com.example.movieapp.model

import androidx.lifecycle.MutableLiveData
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_table")
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    val id: MutableLiveData<Favorite>,
    val title: String,
    val Year: Int,
    val genre: String,
    val language: String,
    val country: String,
    val poster: String,
    val plot: String,
    val director: String,
    val rating: String,
    val actorDetails: List<Actor>,
    val trailer: String
)
