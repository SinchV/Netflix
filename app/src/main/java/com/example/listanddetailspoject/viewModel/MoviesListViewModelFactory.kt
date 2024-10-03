package com.example.listanddetailspoject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listanddetailspoject.repository.MovieRespository

class MoviesListViewModelFactory(private val repository: MovieRespository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoviesListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}