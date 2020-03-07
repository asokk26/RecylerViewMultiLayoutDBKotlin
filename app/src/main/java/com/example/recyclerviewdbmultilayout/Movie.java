package com.example.recyclerviewdbmultilayout;

public class Movie {

    private String title;
    private String descripition;

    public Movie(String title, String descripition) {
        this.title = title;
        this.descripition = descripition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }
}