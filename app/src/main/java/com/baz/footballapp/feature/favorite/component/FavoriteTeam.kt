package com.baz.footballapp.feature.favorite.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.baz.footballapp.data.favorite.source.DummyDataSource

@Composable
fun FavoriteTeam(modifier: Modifier = Modifier, teamName: String, teamLogoUrl: String) {
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
                model = teamLogoUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
                    .weight(2f)
            )
            Text(
                text = teamName,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 8.dp)
                    .weight(5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteTeamPreview() {
    val favoriteTeam = DummyDataSource.dummyFavoriteTeams[0]
    FootballAppTheme {
        FavoriteTeam(teamName = favoriteTeam.name, teamLogoUrl = favoriteTeam.logoUrl)
    }
}