package com.example.recyclerviewdbmultilayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerviewdbmultilayout.databinding.ItemMovieComedyBinding;
import com.example.recyclerviewdbmultilayout.databinding.ItemMovieLoveStoryBinding;

import java.util.List;

class MovieAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> mMovieList;

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    ListItemClickListener itemClickListener;

    public MovieAdapter1(List<Movie> movieList, ListItemClickListener listItemClickListener) {
        this.mMovieList = movieList;
        this.itemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {

            case Movie.COMMEDY_MOVIE_TYPE: {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                ItemMovieComedyBinding itemMovieCommedyBinding = ItemMovieComedyBinding.inflate(layoutInflater, parent, false);
                return new ComedyMovieViewHolder(itemMovieCommedyBinding);
            }
            case Movie.LOVE_STORY_MOVIE_TYPE: {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                ItemMovieLoveStoryBinding itemLoveStoryMovieBinding = ItemMovieLoveStoryBinding.inflate(layoutInflater, parent, false);
                return new LoveStoryMovieViewHolder(itemLoveStoryMovieBinding);
            }

            default:
                // always use a fallback ViewHolder
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                ItemMovieComedyBinding itemBinding = ItemMovieComedyBinding.inflate(layoutInflater, parent, false);
                return new ComedyMovieViewHolder(itemBinding);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mMovieList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Movie movie = mMovieList.get(position);
        if (getItemViewType(position) == Movie.COMMEDY_MOVIE_TYPE) {
            ((ComedyMovieViewHolder) viewHolder).bindCommedyMovie(movie);
        } else {
            ((LoveStoryMovieViewHolder) viewHolder).bindLoveStoryMovie(movie);
        }
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class ComedyMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
        // Since our layout file is item_movie_comedy.xmledy.xml, our auto generated binding class is ItemMovieBinding
        private ItemMovieComedyBinding itemMovieBinding;

        //Define a constructor taking a ItemMovieBinding as its parameter

        public ComedyMovieViewHolder(ItemMovieComedyBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemMovieBinding = itemBinding;
            this.itemMovieBinding.getRoot().setOnClickListener(this);
        }

        /**
         * We will use this function to bind instance of Movie to the row
         */
        public void bindCommedyMovie(Movie movie) {
            itemMovieBinding.setMovieCommedy(movie);
            itemMovieBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            //Call onListItemClick which will trigger the method present in MainActivity.java
            itemClickListener.onListItemClick(getAdapterPosition());
            notifyItemRangeChanged(0, mMovieList.size());
        }
    }


    public class LoveStoryMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
        // Since our layout file is item_movie_comedy.xmledy.xml, our auto generated binding class is ItemMovieBinding
        private ItemMovieLoveStoryBinding itemMovieLoveStoryBinding;

        //Define a constructor taking a ItemMovieBinding as its parameter

        public LoveStoryMovieViewHolder(ItemMovieLoveStoryBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemMovieLoveStoryBinding = itemBinding;
            this.itemMovieLoveStoryBinding.getRoot().setOnClickListener(this);
        }

        /**
         * We will use this function to bind instance of Movie to the row
         */
        public void bindLoveStoryMovie(Movie movie) {
            itemMovieLoveStoryBinding.setMovieLoveStory(movie);
            itemMovieLoveStoryBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            //Call onListItemClick which will trigger the method present in MainActivity.java
            itemClickListener.onListItemClick(getAdapterPosition());
            notifyItemRangeChanged(0, mMovieList.size());
        }
    }
}
