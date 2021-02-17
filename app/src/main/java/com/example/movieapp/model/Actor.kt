package com.example.movieapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("ActorName")
    @Expose
    val actorName: String,
    @SerializedName("ActorPoster")
    @Expose
    val actorImage: String
)