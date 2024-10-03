package com.example.listanddetailspoject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val Base_url="https://www.whats-on-netflix.com/wp-content/plugins/whats-on-netflix/json/"
    val retrofit = Retrofit.Builder()
        .baseUrl(Base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiMovieService = retrofit.create(ApiMovieServices::class.java)
}