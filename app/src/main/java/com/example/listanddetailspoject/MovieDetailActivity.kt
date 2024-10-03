package com.example.listanddetailspoject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

class MovieDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val title = intent.getStringExtra("TITLE") ?: "Movie Title"
            val description = intent.getStringExtra("DESCRIPTION") ?: "Movie Description"
            val imageUrl = intent.getStringExtra("IMAGE_URL") ?: ""
            val rating = intent.getFloatExtra("RATING", 0f)
            val runtime = intent.getStringExtra("RUNTIME") ?: "N/A"
            val language = intent.getStringExtra("LANGUAGE") ?: "N/A"

            MovieDetailScreen(title, description, imageUrl, rating, runtime, language)
        }
    }
}

@Composable
fun MovieDetailScreen(
    title: String,
    description: String,
    imageUrl: String,
    rating: Float,
    runtime: String,
    language: String
) {
    Column(modifier = Modifier.padding(16.dp)) {
        AsyncImage(
            model = imageUrl,
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
        )
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        Text(text = description, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Rating: $rating", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Runtime: $runtime", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Language: $language", style = MaterialTheme.typography.bodyLarge)
    }
}

