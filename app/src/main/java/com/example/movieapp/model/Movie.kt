package com.example.movieapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "movie_table")
data class Movie(
    @SerializedName("Id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("Title")
    @Expose
    val title: String,
    @SerializedName("Year")
    @Expose
    val Year: Int,
    @SerializedName("Genre")
    @Expose
    val genre: String,
    @SerializedName("Language")
    @Expose
    val language: String,
    @SerializedName("Country")
    @Expose
    val country: String,
    @SerializedName("Poster")
    @Expose
    val poster: String,
    @SerializedName("Plot")
    @Expose
    val plot: String,
    @SerializedName("Director")
    @Expose
    val director: String,
    @SerializedName("imdbRating")
    @Expose
    val rating: String,
    @SerializedName("Actors")
    @Expose
    val actorDetails: List<Actor>,
    @SerializedName("trailer")
    @Expose
    val trailer: String

)
