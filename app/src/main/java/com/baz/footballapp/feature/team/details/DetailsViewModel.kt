package com.baz.footballapp.feature.team.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.data.team.repository.TeamRepository
import com.baz.footballapp.feature.team.details.Constants.TEAM_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val repository: TeamRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<DetailsState>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<DetailsState>>
        get() = _uiState

    init {
        savedStateHandle.get<String>(TEAM_ID)?.let { id -> getTeam(id.toInt()) }
    }

    private fun getTeam(id: Int) {
        viewModelScope.launch {
            repository.getTeamById(id).catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect { team ->
                team?.let {
                    _uiState.value = UiState.Success(DetailsState(team))
                } ?: run { _uiState.value = UiState.Error("Something went wrong") }
            }
        }
    }
}