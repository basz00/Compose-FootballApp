package com.baz.footballapp.feature.team.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.team.di.Injection
import com.baz.footballapp.data.team.model.Team
import com.baz.footballapp.data.team.source.DummyDataSource
import com.baz.footballapp.feature.team.ViewModelFactory
import com.baz.footballapp.feature.team.details.components.DetailsClub
import com.baz.footballapp.feature.team.details.components.DetailsVenueAndHeadCoach

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideTeamRepository())
    )
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {}
            is UiState.Success -> DetailsScreen(team = uiState.data.team)
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailsScreen(team: Team) {
    Column(modifier = Modifier.fillMaxWidth()) {
        DetailsClub(teamName = team.name, teamLogoUrl = team.logoUrl, teamFounded = team.founded)
        DetailsVenueAndHeadCoach(
            venue = team.venue,
            venueAddress = team.venueAddress,
            venueCapacity = team.venueCapacity,
            venueImageUrl = team.venueImageUrl,
            headCoach = team.headCoach,
            headCoachImageUrl = team.headCoachImageUrl,
            headCoachAge = team.headCoachAge,
            headCoachNationality = team.headCoachNationality
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    FootballAppTheme {
        DetailsScreen(DummyDataSource.dummyTeams[4])
    }
}