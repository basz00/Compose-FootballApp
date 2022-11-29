package com.baz.footballapp.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.data.favorite.repository.FavoriteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: FavoriteRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<FavoriteState>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<FavoriteState>>
        get() = _uiState

    init {
        getFavoriteTeams()
    }

    private fun getFavoriteTeams() {
        viewModelScope.launch {
            repository.favoriteTeams.collect {
                _uiState.value = UiState.Success(FavoriteState(it))
            }
        }
    }

    fun addOrRemoveTeamToFavorite(teamId: Int) {
        viewModelScope.launch {
            repository.addOrRemoveFavorite(teamId)
        }
    }
}