package com.baz.footballapp.data.favorite.repository

import com.baz.footballapp.data.favorite.model.FavoriteTeam
import kotlinx.coroutines.flow.MutableStateFlow
import com.baz.footballapp.data.favorite.source.DummyDataSource as DummyFavoriteTeamsDataSource
import com.baz.footballapp.data.team.source.DummyDataSource as DummyTeamsDataSource

class FavoriteRepository {

    private val _favoriteTeams =
        MutableStateFlow(DummyFavoriteTeamsDataSource.dummyFavoriteTeams)
    val favoriteTeams = _favoriteTeams

    suspend fun addOrRemoveFavorite(teamId: Int) {
        _favoriteTeams.collect { currentFavoriteTeams ->
            val teamExists = currentFavoriteTeams.any { team -> team.id == teamId }
            if (teamExists) {
                _favoriteTeams.value = currentFavoriteTeams.filterNot { team -> team.id == teamId }
            } else {
                val newFavoriteTeam =
                    DummyTeamsDataSource.dummyTeams.find { team -> team.id == teamId }
                newFavoriteTeam?.let {
                    _favoriteTeams.value = currentFavoriteTeams + FavoriteTeam(
                        newFavoriteTeam.id,
                        newFavoriteTeam.name,
                        newFavoriteTeam.logoUrl
                    )
                }
            }
        }
    }
}