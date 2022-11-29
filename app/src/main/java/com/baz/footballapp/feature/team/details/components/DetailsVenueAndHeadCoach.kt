package com.baz.footballapp.feature.team.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.team.source.DummyDataSource

@Composable
fun DetailsVenueAndHeadCoach(
    modifier: Modifier = Modifier,
    venue: String,
    venueAddress: String,
    venueCapacity: Int,
    venueImageUrl: String,
    headCoach: String,
    headCoachImageUrl: String,
    headCoachAge: Int,
    headCoachNationality: String
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        DetailsVenue(
            venue = venue,
            venueAddress = venueAddress,
            venueCapacity = venueCapacity,
            venueImageUrl = venueImageUrl,
            modifier = Modifier
                .padding(start = 8.dp, end = 4.dp)
                .weight(1f)
        )
        DetailsHeadCoach(
            headCoach = headCoach,
            headCoachImageUrl = headCoachImageUrl,
            headCoachAge = headCoachAge,
            headCoachNationality = headCoachNationality,
            modifier = Modifier
                .padding(start = 4.dp, end = 8.dp)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsVenueAndHeadCoachPreview() {
    val dummyTeam = DummyDataSource.dummyTeams[0]
    FootballAppTheme {
        DetailsVenueAndHeadCoach(
            venue = dummyTeam.venue,
            venueAddress = dummyTeam.venueAddress,
            venueCapacity = dummyTeam.venueCapacity,
            venueImageUrl = dummyTeam.venueImageUrl,
            headCoach = dummyTeam.headCoach,
            headCoachImageUrl = dummyTeam.headCoachImageUrl,
            headCoachAge = dummyTeam.headCoachAge,
            headCoachNationality = dummyTeam.headCoachNationality
        )
    }
}