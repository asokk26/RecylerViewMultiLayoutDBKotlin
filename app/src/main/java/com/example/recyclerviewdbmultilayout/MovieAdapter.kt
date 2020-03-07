package com.example.recyclerviewdbmultilayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewdbmultilayout.databinding.ItemMovieComedyBinding
import com.example.recyclerviewdbmultilayout.databinding.ItemMovieLoveStoryBinding

internal class MovieAdapter(private val mMovieList: List<Movie>, var itemClickListener: ListItemClickListener) : RecyclerView.Adapter<ViewHolder>() {

    interface ListItemClickListener {
        fun onListItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            Movie.COMMEDY_MOVIE_TYPE -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemMovieCommedyBinding = ItemMovieComedyBinding.inflate(layoutInflater, parent, false)
                ComedyMovieViewHolder(itemMovieCommedyBinding)
            }
            Movie.LOVE_STORY_MOVIE_TYPE -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemLoveStoryMovieBinding = ItemMovieLoveStoryBinding.inflate(layoutInflater, parent, false)
                LoveStoryMovieViewHolder(itemLoveStoryMovieBinding)
            }
            else -> {
                // always use a fallback ViewHolder
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemBinding = ItemMovieComedyBinding.inflate(layoutInflater, parent, false)
                ComedyMovieViewHolder(itemBinding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return mMovieList[position].viewType
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie = mMovieList[position]
        if (getItemViewType(position) == Movie.COMMEDY_MOVIE_TYPE) {
            (viewHolder as ComedyMovieViewHolder).bindCommedyMovie(movie)
        } else {
            (viewHolder as LoveStoryMovieViewHolder).bindLoveStoryMovie(movie)
        }
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }

    inner class ComedyMovieViewHolder(// If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
            // Since our layout file is item_movie_comedy.xmledy.xml, our auto generated binding class is ItemMovieBinding
            private val itemMovieBinding: ItemMovieComedyBinding) : ViewHolder(itemMovieBinding.root), View.OnClickListener {

        /**
         * We will use this function to bind instance of Movie to the row
         */
        fun bindCommedyMovie(movie: Movie?) {
            itemMovieBinding.movieCommedy = movie
            itemMovieBinding.executePendingBindings()
        }

        override fun onClick(v: View) {
            //Call onListItemClick which will trigger the method present in MainActivity.java
            itemClickListener.onListItemClick(adapterPosition)
            notifyItemRangeChanged(0, mMovieList.size)
        }

        //Define a constructor taking a ItemMovieBinding as its parameter
        init {
            itemMovieBinding.root.setOnClickListener(this)
        }
    }

    inner class LoveStoryMovieViewHolder(// If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
            // Since our layout file is item_movie_comedy.xmledy.xml, our auto generated binding class is ItemMovieBinding
            private val itemMovieLoveStoryBinding: ItemMovieLoveStoryBinding) : ViewHolder(itemMovieLoveStoryBinding.root), View.OnClickListener {

        /**
         * We will use this function to bind instance of Movie to the row
         */
        fun bindLoveStoryMovie(movie: Movie?) {
            itemMovieLoveStoryBinding.movieLoveStory = movie
            itemMovieLoveStoryBinding.executePendingBindings()
        }

        override fun onClick(v: View) {
            //Call onListItemClick which will trigger the method present in MainActivity.java
            itemClickListener.onListItemClick(adapterPosition)
            notifyItemRangeChanged(0, mMovieList.size)
        }

        //Define a constructor taking a ItemMovieBinding as its parameter
        init {
            itemMovieLoveStoryBinding.root.setOnClickListener(this)
        }
    }

}