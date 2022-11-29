package com.baz.footballapp.feature.about

sealed class Screen(val route: String) {
    object About : Screen("about")
}