package com.baz.footballapp.feature.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baz.footballapp.core.common.UiState
import com.baz.footballapp.data.about.repository.AboutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class AboutViewModel(private val repository: AboutRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<AboutState>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<AboutState>>
        get() = _uiState

    init {
        getAbout()
    }

    private fun getAbout() {
        viewModelScope.launch {
            repository.getAbout().catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect { about ->
                _uiState.value = UiState.Success(AboutState(about))
            }
        }
    }
}