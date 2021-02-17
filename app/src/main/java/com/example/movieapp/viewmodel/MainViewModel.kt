package com.example.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.model.Movie
import com.example.movieapp.db.repository.Repository
import com.example.movieapp.ui.adapter.MovieAdapter
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel(private val repository: Repository):ViewModel() {
    val allMovieResponse:MutableLiveData<List<Movie>> = MutableLiveData()
    val allMovieResponseList:MutableLiveData<Response<List<Movie>>> = MutableLiveData()

//    fun getAllMovie(){
//        viewModelScope.launch {
//            val movieResponse = repository.getAllMovie()
//            allMovieResponse.value = movieResponse
//        }
//    }

//    fun allMovieList(){
//        viewModelScope.launch {
//            val r = repository.getAllMovieList()
//            allMovieResponseList.value = r
//        }
//    }

    fun allMovie(){
        viewModelScope.launch {
            val r = repository.getAllMovieDB()
            allMovieResponse.value = r
        }
    }

    fun searchMovie(title: String){
        viewModelScope.launch {
            val s = repository.searchData(title)
            allMovieResponse.value = s
        }
    }
}