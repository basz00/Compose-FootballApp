package com.baz.footballapp.feature.about

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.about.di.Injection
import com.baz.footballapp.data.about.model.About
import com.baz.footballapp.data.about.source.DummyDataSource

@Composable
fun AboutScreen(
    viewModel: AboutViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideAboutRepository()
        )
    )
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {}
            is UiState.Success -> AboutScreen(about = uiState.data.about)
            is UiState.Error -> {}
        }
    }
}


@Composable
fun AboutScreen(about: About) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = about.photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp)
            )
            Text(text = about.name, style = MaterialTheme.typography.titleLarge)
            Text(text = about.email, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    FootballAppTheme {
        AboutScreen(DummyDataSource.dummyAbout)
    }
}