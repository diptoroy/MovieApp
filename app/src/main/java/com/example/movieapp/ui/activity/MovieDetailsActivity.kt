package com.example.movieapp.ui.activity

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.db.repository.Repository
import com.example.movieapp.model.Favorite
import com.example.movieapp.ui.adapter.ActorAdapter
import com.example.movieapp.ui.adapter.MovieAdapter
import com.example.movieapp.viewmodel.MainViewModel
import com.example.movieapp.viewmodel.MainViewModelFactory
import com.example.movieapp.viewmodel.MovieDeatilsViewModel
import com.example.movieapp.viewmodel.MovieDetailsViewModelFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.halilibo.bvpkotlin.BetterVideoPlayer
import com.norulab.exofullscreen.preparePlayer
import com.norulab.exofullscreen.setSource
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity(){

    private lateinit var actorViewModel: MovieDeatilsViewModel
    private val actorAdapter by lazy { ActorAdapter() }
    private var isFav: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)


        val repository = Repository(this)
        val viewModelFactory = MovieDetailsViewModelFactory(repository)
        actorViewModel = ViewModelProvider(this,viewModelFactory).get(MovieDeatilsViewModel::class.java)

        setUpPostRecyclerView()
        actorViewModel.actorDetail()
        actorViewModel.actorResponse.observe(this, Observer {actorList ->
            actorAdapter.setData(actorList)
        })

        initBundle()


        favBtn.setOnClickListener {
            if (isFav){
                isFav = false
                favBtn.supportImageTintList = ColorStateList.valueOf(Color.parseColor("#E4C1C1"))

                Log.d("msg","Not Favorite!")
            }else{
                isFav = true
                favBtn.supportImageTintList = ColorStateList.valueOf(Color.parseColor("#FFC107"))
                Log.d("msg","Favorite!")
            }
        }

    }

    private fun initBundle() {
        val bundle:Bundle? = intent.extras
        movieTitle.text = bundle!!.getString("title")
        directorbc.text = bundle.getString("director")
        genre.text = bundle.getString("genre")
        releaseYear.text = bundle.getInt("year").toString()
        language.text = bundle.getString("language")
        country.text = bundle.getString("country")
        rating.text = bundle.getString("rating")
        plotText.text = bundle.getString("plot")
        //moviePosterD.setImageDrawable(bundle!!.getString("image"))
        Glide.with(this).load(bundle.getString("image")).into(moviePosterD);

        val player = SimpleExoPlayer.Builder(this).build()
        player.preparePlayer(movieView)
        player.setSource(applicationContext, "http://html5videoformatconverter.com/data/images/happyfit2.mp4")

    }

    private fun setUpPostRecyclerView(){
        actorRecyclerview.adapter = actorAdapter
        actorRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

}




