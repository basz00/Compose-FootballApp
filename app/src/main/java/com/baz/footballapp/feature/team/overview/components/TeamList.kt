package com.baz.footballapp.feature.team.overview.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baz.footballapp.core.ui.components.SearchBar
import com.baz.footballapp.core.ui.theme.FootballAppTheme
import com.baz.footballapp.data.team.model.Team
import com.baz.footballapp.data.team.source.DummyDataSource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TeamList(
    modifier: Modifier = Modifier,
    teams: List<Team>,
    onItemClicked: (Int) -> Unit = {},
    onQueryChanged: (String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .padding(horizontal = 8.dp)
    ) {
        item { SearchBar(onQueryChange = onQueryChanged) }
        item { Spacer(modifier = Modifier.padding(vertical = 4.dp)) }
        teams.forEach { team ->
            item(key = team.id) {
                Team(
                    name = team.name,
                    logoUrl = team.logoUrl,
                    venue = team.venue,
                    venueAddress = team.venueAddress,
                    modifier = Modifier
                        .clickable { onItemClicked(team.id) }
                        .animateItemPlacement()
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemListPreview() {
    FootballAppTheme {
        TeamList(
            teams = DummyDataSource.dummyTeams
        )
    }
}