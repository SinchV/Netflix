package com.example.listanddetailspoject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listanddetailspoject.model.Netflix
import com.example.listanddetailspoject.repository.MovieRespository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoviesListViewModel(private val repo:MovieRespository):ViewModel() {
    private  val _movies= MutableStateFlow<List<Netflix>>(emptyList())
    val movieList: StateFlow<List<Netflix>> get()=_movies
    init {
        fetchMovies()
    }
    fun  fetchMovies(){
        viewModelScope.launch {
            val movieList = repo.getMovieLists()
          _movies.value=movieList
        }
    }
}
