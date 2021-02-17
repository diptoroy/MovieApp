package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import kotlinx.android.synthetic.main.actor_row.view.*
import kotlinx.android.synthetic.main.movie_row.view.*

class ActorAdapter:RecyclerView.Adapter<ActorAdapter.ViewHolder>(){

    private var actor = emptyList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_row,parent,false)
        return ActorAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorAdapter.ViewHolder, position: Int) {
        holder.itemView.acotrName.text = actor[position].actorDetails[position].actorName
        Glide.with(holder.itemView.context).load(actor[position].actorDetails[position].actorImage).into(holder.itemView.actorImage)
    }

    override fun getItemCount(): Int {
        return actor.size
    }

    fun setData(newList: List<Movie>){
        notifyDataSetChanged()
        actor = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}