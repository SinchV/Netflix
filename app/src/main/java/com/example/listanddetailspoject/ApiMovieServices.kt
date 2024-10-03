package com.example.listanddetailspoject

import com.example.listanddetailspoject.model.Netflix
import retrofit2.http.GET

interface ApiMovieServices {
    @GET("alldocs.json")
    suspend fun  getAllMovies():List<Netflix>
}


