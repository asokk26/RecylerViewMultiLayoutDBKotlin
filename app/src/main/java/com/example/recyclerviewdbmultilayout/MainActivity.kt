package com.example.recyclerviewdbmultilayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdbmultilayout.MovieAdapter.ListItemClickListener
import com.example.recyclerviewdbmultilayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListItemClickListener {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = binding!!.rvMovieList // In xml we have given id rv_movie_list to RecyclerView
        val layoutManager = LinearLayoutManager(this) // you can use getContext() instead of "this"
        recyclerView.layoutManager = layoutManager

        val horizontalDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val horizontalDivider = ContextCompat.getDrawable(this, R.drawable.horizontal_divider)!!
        horizontalDecoration.setDrawable(horizontalDivider!!)
        recyclerView.addItemDecoration(horizontalDecoration)

        val adapter = MovieAdapter(mMovieList, this)
        recyclerView.adapter = adapter
    }

    private val mMovieList = listOf(
            Movie(Movie.LOVE_STORY_MOVIE_TYPE, "CHENNAI EXPRESS", "LOVE STORY",0),
            Movie(Movie.COMMEDY_MOVIE_TYPE, "HOUSE FULL", "COMEDY", R.drawable.housefull),
            Movie(Movie.LOVE_STORY_MOVIE_TYPE, "DIL CHAHTA HAI", "LOVE STORY", 0),
            Movie(Movie.COMMEDY_MOVIE_TYPE, "GARAM MASALA", "COMEDY", R.drawable.garam_masala),
            Movie(Movie.COMMEDY_MOVIE_TYPE, "GOLMAAL AGAIN", "COMEDY", R.drawable.golmaal)
    )

    override fun onListItemClick(position: Int) {
        //You will get position of the item clicked depending on your situation perform a desired action. We are simply Toasting.
        Toast.makeText(this, "$position item clicked! ", Toast.LENGTH_LONG).show()
    }
}