package com.example.recyclerviewdbmultilayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewdbmultilayout.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ListItemClickListener {

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

        mMovieList = new ArrayList<>();
        mMovieList.add(new Movie("CHENNAI EXPRESS", "LOVE STORY"));
        mMovieList.add(new Movie("BORDER", "PATRIOTRIC"));
        mMovieList.add(new Movie("SINGHAM", "ACTION"));
        mMovieList.add(new Movie("GARAM MASALA", "COMEDY"));
        // ...
        MovieAdapter adapter = new MovieAdapter(mMovieList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(int position) {
        //You will get position of the item clicked depending on your situation perform a desired action. We are simply Toasting.
        Toast.makeText(this, position + " item clicked! ", Toast.LENGTH_LONG).show();
    }
}