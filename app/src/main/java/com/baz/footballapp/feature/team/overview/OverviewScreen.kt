package com.baz.footballapp.feature.team.overview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.team.di.Injection
import com.baz.footballapp.data.team.model.Team
import com.baz.footballapp.feature.team.ViewModelFactory
import com.baz.footballapp.feature.team.overview.components.TeamList

@Composable
fun OverviewScreen(
    viewModel: OverviewViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideTeamRepository())
    ),
    navigateToDetails: (Int) -> Unit = {}
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {}
            is UiState.Success -> OverviewScreen(
                teams = uiState.data.teams,
                navigateToDetails = navigateToDetails,
                filterTeams = { viewModel.getTeams(it) }
            )
            is UiState.Error -> {}
        }
    }
}

@Composable
fun OverviewScreen(
    teams: List<Team>,
    navigateToDetails: (Int) -> Unit,
    filterTeams: (String) -> Unit
) {
    TeamList(
        teams = teams,
        onItemClicked = navigateToDetails,
        onQueryChanged = filterTeams
    )
}

@Preview(showBackground = true)
@Composable
fun OverviewScreenPreview() {
    FootballAppTheme {
        OverviewScreen()
    }
}