package com.baz.footballapp.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baz.footballapp.core.ui.components.TopBar
import com.baz.footballapp.feature.about.AboutScreen
import com.baz.footballapp.feature.favorite.FavoriteScreen
import com.baz.footballapp.feature.team.details.DetailsScreen
import com.baz.footballapp.feature.team.overview.OverviewScreen
import com.baz.footballapp.feature.about.Screen as AboutScreen
import com.baz.footballapp.feature.favorite.Screen as FavoriteScreen
import com.baz.footballapp.feature.team.Screen as TeamScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootballApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            TopBar(
                navigateToAbout = { navHostController.navigate(AboutScreen.About.route) },
                navigateToFavorite = { navHostController.navigate(FavoriteScreen.Favorite.route) }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = TeamScreen.Overview.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(TeamScreen.Overview.route) {
                OverviewScreen(navigateToDetails = { teamId ->
                    navHostController.navigate(
                        TeamScreen.Details.createRoute(teamId)
                    )
                })
            }
            composable(route = TeamScreen.Details.route) {
                DetailsScreen()
            }
            composable(route = AboutScreen.About.route) {
                AboutScreen()
            }
            composable(route = FavoriteScreen.Favorite.route) {
                FavoriteScreen()
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FootballApp()
}