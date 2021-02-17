package com.example.movieapp.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromActor(actor: List<Actor>):String{
        val type = object : TypeToken<List<Actor>>() {}.type
        return Gson().toJson(actor,type)
    }

    @TypeConverter
    fun toActor(actorString: String): List<Actor>{
        val type = object : TypeToken<List<Actor>>() {}.type
        return Gson().fromJson<List<Actor>>(actorString,type)
    }
}