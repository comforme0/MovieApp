package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.MainActivity.Companion.IMAGE_URI
import com.example.movieapp.R
import com.example.movieapp.model.Movie

class MovieAdapter(private val movieList : ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val poster = itemView.findViewById<ImageView>(R.id.poster)
        val titleMovie = itemview.findViewById<EditText>(R.id.titleMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(IMAGE_URI + movieList[position].backdrop_path).into(holder.poster)
        holder.titleMovie.setText(movieList[position].title.toString())
    }
}