package com.baz.footballapp.data.about.di

import com.baz.footballapp.data.about.repository.AboutRepository

object Injection {

    fun provideAboutRepository() = AboutRepository()
}