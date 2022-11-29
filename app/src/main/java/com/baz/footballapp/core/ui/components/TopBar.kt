package com.baz.footballapp.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.baz.footballapp.R
import com.baz.footballapp.core.ui.theme.FootballAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navigateToAbout: () -> Unit = {},
    navigateToFavorite: () -> Unit = {}
) {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        modifier = modifier,
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "about_page")
            }
            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(
                    text = { Text(text = stringResource(id = R.string.about)) },
                    onClick = {
                        showMenu = false
                        navigateToAbout()
                    })
                DropdownMenuItem(
                    text = { Text(text = stringResource(id = R.string.favorite)) },
                    onClick = {
                        showMenu = false
                        navigateToFavorite()
                    })
            }
        },
    )
}

@Preview
@Composable
fun TopBarPreview() {
    FootballAppTheme {
        TopBar()
    }
}