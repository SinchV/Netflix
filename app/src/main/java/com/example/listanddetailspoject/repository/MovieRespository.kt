package com.example.listanddetailspoject.repository

import com.example.listanddetailspoject.ApiMovieServices
import com.example.listanddetailspoject.model.Netflix

class MovieRespository(private  val apiService:ApiMovieServices) {
    suspend fun getMovieLists(): List<Netflix> {
        return apiService.getAllMovies()
    }
}