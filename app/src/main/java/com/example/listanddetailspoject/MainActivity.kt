package com.example.listanddetailspoject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.listanddetailspoject.repository.MovieRespository
import com.example.listanddetailspoject.ui.theme.ListAndDetailsPojectTheme
import com.example.listanddetailspoject.viewModel.MoviesListViewModel
import com.example.listanddetailspoject.viewModel.MoviesListViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MoviesListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListAndDetailsPojectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val repository = MovieRespository(RetrofitInstance.apiMovieService)
                    viewModel = ViewModelProvider(this, MoviesListViewModelFactory(repository))
                        .get(MoviesListViewModel::class.java)
                    MoviesListScreen(viewModel)
                }
            }
        }
    }
}

