package com.example.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.db.repository.Repository
import com.example.movieapp.model.Favorite
import com.example.movieapp.model.Movie
import kotlinx.coroutines.launch

class MovieDeatilsViewModel(private val repository: Repository):ViewModel() {
    private val favMovieResponse:MutableLiveData<List<Favorite>> = MutableLiveData()
    val actorResponse:MutableLiveData<List<Movie>> = MutableLiveData()
    private val insertFavMovie:MutableLiveData<Favorite> = MutableLiveData()

    fun actorDetail(){
        viewModelScope.launch {
            val actor = repository.getAllMovieDB()
            actorResponse.value = actor
        }
    }
    //when user click the save btn then this movie item save in database fav_table
    fun insertFavMovie(favorite: Favorite){
        viewModelScope.launch {
            val insertFav = repository.insertFavMovie(favorite)
            //insertFavMovie.value = insertFav
        }
    }

}