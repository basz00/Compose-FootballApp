package com.baz.footballapp.data.favorite.di

import com.baz.footballapp.data.favorite.repository.FavoriteRepository

object Injection {

    fun provideFavoriteRepository() = FavoriteRepository()
}