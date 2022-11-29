package com.baz.footballapp.feature.team.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.data.team.repository.TeamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class OverviewViewModel(private val repository: TeamRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<OverviewState>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OverviewState>>
        get() = _uiState

    init {
        getTeams()
    }

    fun getTeams(query: String = "") {
        viewModelScope.launch {
            repository.getTeams(query).catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect {
                _uiState.value = UiState.Success(OverviewState(it))
            }
        }
    }
}