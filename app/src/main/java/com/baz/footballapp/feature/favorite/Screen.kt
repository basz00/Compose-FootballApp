package com.baz.footballapp.feature.favorite

sealed class Screen(val route: String) {
    object Favorite : Screen("favorite")
}