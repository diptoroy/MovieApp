package com.example.movieapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import com.example.movieapp.ui.activity.MovieDetailsActivity
import kotlinx.android.synthetic.main.movie_row.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movie = emptyList<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.itemView.movieName.text = movie[position].title.toString()
        holder.itemView.movieYearR.text = movie[position].Year.toString()
        holder.itemView.movieGenreR.text = movie[position].genre.toString()
        holder.itemView.movieRatingR.text = movie[position].language.toString()
        Glide.with(holder.itemView.context).load(movie[position].poster).into(holder.itemView.moviePoster)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,MovieDetailsActivity::class.java)
            intent.putExtra("title",movie[position].title)
            intent.putExtra("director",movie[position].director)
            intent.putExtra("genre",movie[position].genre)
            intent.putExtra("year",movie[position].Year).toString()
            intent.putExtra("language",movie[position].language)
            intent.putExtra("country",movie[position].country)
            intent.putExtra("rating",movie[position].rating)
            intent.putExtra("plot",movie[position].plot)
            intent.putExtra("image",movie[position].poster)
            intent.putExtra("trailer",movie[position].trailer)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return movie.size
    }

    fun setData(newList: List<Movie>){
        notifyDataSetChanged()
        movie = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}