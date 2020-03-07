package com.example.recyclerviewdbmultilayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdbmultilayout.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity implements MovieAdapter.ListItemClickListener {

    private ActivityMainBinding binding;

    private List<Movie> mMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = binding.rvMovieList; // In xml we have given id rv_movie_list to RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // you can use getContext() instead of "this"
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(this, R.drawable.horizontal_divider);
        assert horizontalDivider != null;
        horizontalDecoration.setDrawable(horizontalDivider);
        recyclerView.addItemDecoration(horizontalDecoration);

        mMovieList = new ArrayList<>();
        mMovieList.add(new Movie(Movie.LOVE_STORY_MOVIE_TYPE, "CHENNAI EXPRESS", "LOVE STORY",0));
        mMovieList.add(new Movie(Movie.COMMEDY_MOVIE_TYPE, "HOUSE FULL", "COMEDY", R.drawable.housefull));
        mMovieList.add(new Movie(Movie.LOVE_STORY_MOVIE_TYPE, "DIL CHAHTA HAI", "LOVE STORY", 0));
        mMovieList.add(new Movie(Movie.COMMEDY_MOVIE_TYPE, "GARAM MASALA", "COMEDY", R.drawable.garam_masala));
        mMovieList.add(new Movie(Movie.COMMEDY_MOVIE_TYPE, "GOLMAAL AGAIN", "COMEDY", R.drawable.golmaal));

        MovieAdapter adapter = new MovieAdapter(mMovieList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(int position) {
        //You will get position of the item clicked depending on your situation perform a desired action. We are simply Toasting.
        Toast.makeText(this, position + " item clicked! ", Toast.LENGTH_LONG).show();
    }
}

