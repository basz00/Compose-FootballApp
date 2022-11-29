package com.baz.footballapp.feature.team

sealed class Screen(val route: String) {
    object Overview : Screen("overview")
    object Details : Screen("details/{teamId}") {
        fun createRoute(teamId: Int) = "details/${teamId}"
    }
}