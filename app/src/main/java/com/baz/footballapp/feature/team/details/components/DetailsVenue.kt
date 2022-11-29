package com.baz.footballapp.feature.team.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.baz.footballapp.R
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.team.source.DummyDataSource

@Composable
fun DetailsVenue(
    modifier: Modifier = Modifier,
    venue: String,
    venueAddress: String,
    venueCapacity: Int,
    venueImageUrl: String,
) {
    Card(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.venue),
                style = MaterialTheme.typography.titleLarge
            )
            AsyncImage(
                model = venueImageUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
            )
            Text(text = venue, style = MaterialTheme.typography.titleMedium)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(Icons.Rounded.Person, contentDescription = "", modifier = Modifier.size(20.dp))
                Text(text = "" + venueCapacity, style = MaterialTheme.typography.bodyMedium)
            }
            Text(text = venueAddress, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsVenuePreview() {
    val dummyTeam = DummyDataSource.dummyTeams[0]
    FootballAppTheme {
        DetailsVenue(
            venue = dummyTeam.venue,
            venueAddress = dummyTeam.venueAddress,
            venueCapacity = dummyTeam.venueCapacity,
            venueImageUrl = dummyTeam.venueImageUrl
        )
    }
}