package com.baz.footballapp.feature.team.details.components

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.baz.footballapp.R
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.team.source.DummyDataSource

@Composable
fun DetailsHeadCoach(
    modifier: Modifier = Modifier,
    headCoach: String,
    headCoachImageUrl: String,
    headCoachAge: Int,
    headCoachNationality: String
) {
    Card(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.head_coach),
                style = MaterialTheme.typography.titleLarge
            )
            AsyncImage(
                model = headCoachImageUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
            )
            Text(
                text = headCoach,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(id = R.string.age, headCoachAge),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(text = headCoachNationality, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsHeadCoachPreview() {
    val dummyTeam = DummyDataSource.dummyTeams[0]
    FootballAppTheme {
        DetailsHeadCoach(
            headCoach = dummyTeam.headCoach,
            headCoachImageUrl = dummyTeam.headCoachImageUrl,
            headCoachAge = dummyTeam.headCoachAge,
            headCoachNationality = dummyTeam.headCoachNationality
        )
    }
}