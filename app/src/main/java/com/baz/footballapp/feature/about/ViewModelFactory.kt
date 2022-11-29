package com.baz.footballapp.feature.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baz.footballapp.data.about.repository.AboutRepository

class ViewModelFactory(private val aboutRepository: AboutRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AboutViewModel::class.java)) {
            return AboutViewModel(aboutRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}