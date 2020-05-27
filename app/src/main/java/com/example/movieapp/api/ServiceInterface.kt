package com.example.movieapp.api

import com.example.movieapp.model.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceInterface {
    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") api_key : String
    ) : Call<ResponseMovie>
}