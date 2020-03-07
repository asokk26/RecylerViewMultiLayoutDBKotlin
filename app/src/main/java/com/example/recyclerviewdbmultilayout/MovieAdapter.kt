package com.example.recyclerviewdbmultilayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewdbmultilayout.MovieAdapter.MovieViewHolder
import com.example.recyclerviewdbmultilayout.databinding.ItemMovieBinding

internal class MovieAdapter(private val mMovieList: List<Movie>, var itemClickListener: ListItemClickListener) : RecyclerView.Adapter<MovieViewHolder>() {

    interface ListItemClickListener {
        fun onListItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = mMovieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }

    inner class MovieViewHolder(// If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
            // Since our layout file is item_movie.xml, our auto generated binding class is ItemMovieBinding
            private val itemMovieBinding: ItemMovieBinding) : ViewHolder(itemMovieBinding.root), View.OnClickListener {

        /**
         * We will use this function to bind instance of Movie to the row
         */
        fun bind(movie: Movie?) {
            itemMovieBinding.movie = movie
            itemMovieBinding.executePendingBindings()
        }

        override fun onClick(v: View) {
            //Call onListItemClick which will trigger the method present in MainActivity.java
            itemClickListener.onListItemClick(adapterPosition)
            notifyItemRangeChanged(0, mMovieList.size)
        }

        init {
            itemMovieBinding.root.setOnClickListener(this)
        }
    }

}