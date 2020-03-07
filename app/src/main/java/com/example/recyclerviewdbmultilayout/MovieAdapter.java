package com.example.recyclerviewdbmultilayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdbmultilayout.databinding.ItemMovieBinding;

import java.util.List;

class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> mMovieList;

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    ListItemClickListener itemClickListener;

    public MovieAdapter(List<Movie> movieList, ListItemClickListener listItemClickListener) {
        this.mMovieList = movieList;
        this.itemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding itemBinding = ItemMovieBinding.inflate(layoutInflater, parent, false);
        return new MovieViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
        // Since our layout file is item_movie.xml, our auto generated binding class is ItemMovieBinding
        private ItemMovieBinding itemMovieBinding;

        //Define a constructor taking a ItemMovieBinding as its parameter

        private LinearLayout mMovieLayout;

        public MovieViewHolder(ItemMovieBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemMovieBinding = itemBinding;
            this.itemMovieBinding.getRoot().setOnClickListener(this);
        }

        /**
         * We will use this function to bind instance of Movie to the row
         */
        public void bind(Movie movie) {
            itemMovieBinding.setMovie(movie);
            itemMovieBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            //Call onListItemClick which will trigger the method present in MainActivity.java
            itemClickListener.onListItemClick(getAdapterPosition());
            notifyItemRangeChanged(0, mMovieList.size());
        }
    }
}