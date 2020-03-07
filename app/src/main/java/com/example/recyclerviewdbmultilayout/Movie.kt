package com.example.recyclerviewdbmultilayout

class Movie(var viewType: Int, var title: String, var descripition: String, var photo: Int) {

    companion object {
        //Add the type indicators here
        const val COMMEDY_MOVIE_TYPE = 0
        const val LOVE_STORY_MOVIE_TYPE = 1
    }
}