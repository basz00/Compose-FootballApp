package com.baz.footballapp.feature.favorite.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.favorite.model.FavoriteTeam
import com.baz.footballapp.data.favorite.source.DummyDataSource

@Composable
fun FavoriteTeamList(
    modifier: Modifier = Modifier,
    favoriteTeams: List<FavoriteTeam>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .padding(horizontal = 8.dp)
    ) {
        item { Spacer(modifier = Modifier.padding(vertical = 4.dp)) }
        favoriteTeams.forEach { team ->
            item(key = team.id) {
                FavoriteTeam(
                    teamName = team.name,
                    teamLogoUrl = team.logoUrl,
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteTeamListPreview() {
    FootballAppTheme {
        FavoriteTeamList(favoriteTeams = DummyDataSource.dummyFavoriteTeams)
    }
}