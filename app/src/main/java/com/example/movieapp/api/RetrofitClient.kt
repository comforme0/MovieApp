package com.example.movieapp.api

import com.example.movieapp.MainActivity.Companion.BASE_URI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private var instance : Retrofit? = null

    fun getInstance() : Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance!!
    }
}