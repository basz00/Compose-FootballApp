package com.baz.footballapp.feature.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.favorite.di.Injection
import com.baz.footballapp.data.favorite.model.FavoriteTeam
import com.baz.footballapp.feature.favorite.component.FavoriteTeamList

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideFavoriteRepository())
    )
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {}
            is UiState.Success -> FavoriteScreen(
                favoriteTeams = uiState.data.favoriteTeams
            )
            is UiState.Error -> {}
        }
    }
}

@Composable
fun FavoriteScreen(
    favoriteTeams: List<FavoriteTeam>
) {
    FavoriteTeamList(
        favoriteTeams = favoriteTeams,
    )
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    FootballAppTheme {
        FavoriteScreen()
    }
}