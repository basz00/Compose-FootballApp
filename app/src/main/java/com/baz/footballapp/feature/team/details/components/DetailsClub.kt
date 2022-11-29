package com.baz.footballapp.feature.team.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
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
fun DetailsClub(
    modifier: Modifier = Modifier,
    teamName: String,
    teamLogoUrl: String,
    teamFounded: Int
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = teamLogoUrl,
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
                    .weight(5f)
            ) {
                Text(text = teamName, style = MaterialTheme.typography.titleLarge)
                Text(
                    text = stringResource(id = R.string.founded),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(text = "" + teamFounded, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsClubPreview() {
    val team = DummyDataSource.dummyTeams[0]
    FootballAppTheme {
        DetailsClub(teamName = team.name, teamLogoUrl = team.logoUrl, teamFounded = team.founded)
    }
}