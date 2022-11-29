package com.baz.footballapp.data.team.di

import com.baz.footballapp.data.team.repository.TeamRepository

object Injection {

    fun provideTeamRepository() = TeamRepository()
}