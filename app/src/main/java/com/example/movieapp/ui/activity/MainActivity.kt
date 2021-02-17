package com.example.movieapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.db.repository.Repository
import com.example.movieapp.model.Movie
import com.example.movieapp.ui.adapter.MovieAdapter
import com.example.movieapp.viewmodel.MainViewModel
import com.example.movieapp.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val movieAdapter by lazy { MovieAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository(this)
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        //Glide.with(this).load(response.body()?.poster.toString()).into(movieImage)
        //recyclerview
        setUpPostRecyclerView()
        viewModel.allMovie()
        viewModel.allMovieResponse.observe(this, Observer {movieList ->
            movieAdapter.setData(movieList)
        })
//        viewModel.allMovieList()
//        viewModel.allMovieResponseList.observe(this, Observer { response ->
//            if (response.isSuccessful){
//                response.body()?.let { movieAdapter.setData(it) }
//            }else{
//
//            }
//        })

        //search
        movieSearchView.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null){
                    search(query)
                }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (query != null){
                    search(query)
                }
                return true
            }

        })

    }

    private fun search(query: String){
        val title = "%$query%"
        viewModel.searchMovie(title)
        viewModel.allMovieResponse.observe(this, Observer { movieList ->
            movieList.let {
                movieAdapter.setData(it)
            }
        })
    }

    private fun setUpPostRecyclerView(){
        movieRecyclerView.adapter = movieAdapter
        movieRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}