package com.example.listanddetailspoject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberImagePainter
import com.example.listanddetailspoject.model.Netflix
import com.example.listanddetailspoject.viewModel.MoviesListViewModel
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MoviesListScreen(viewModel: MoviesListViewModel) {
 val movieItemList = viewModel.movieList.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Movies") })
        },
        content = {
            if (movieItemList.isEmpty()) {
                viewModel.fetchMovies()
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(movieItemList) { movie ->
                    MovieItem(movie = movie)
                }
            }
        }
    )
}

@Composable
fun MovieItem(movie: Netflix) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val intent = Intent(context, MovieDetailActivity::class.java).apply {
                    putExtra("TITLE", movie.title)
                    putExtra("DESCRIPTION", movie.description)
                    putExtra("IMAGE_URL", movie.image_portrait)
                    putExtra("RATING", movie.rating)
                    putExtra("RUNTIME", movie.runtime)
                    putExtra("LANGUAGE", movie.language)
                }
                context.startActivity(intent) },


    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(movie.image_portrait),
                contentDescription = movie.title,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 8.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Rating: ${movie.rating}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Language: ${movie.language}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}


