package com.example.movieapp.model

data class ResponseMovie(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: ArrayList<Movie>
)