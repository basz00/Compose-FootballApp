package com.baz.footballapp.feature.team.overview.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.team.source.DummyDataSource

@Composable
fun Team(
    modifier: Modifier = Modifier,
    name: String,
    logoUrl: String,
    venue: String,
    venueAddress: String,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = logoUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
                    .weight(2f)
            )
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 8.dp)
                    .weight(5f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = venueAddress, style = MaterialTheme.typography.titleMedium)
                Text(text = venue, style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamPreview() {
    val team = DummyDataSource.dummyTeams[0]
    FootballAppTheme() {
        Team(
            name = team.name,
            logoUrl = team.logoUrl,
            venue = team.venue,
            venueAddress = team.venueAddress
        )
    }
}