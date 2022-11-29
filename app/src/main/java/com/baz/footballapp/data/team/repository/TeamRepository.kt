package com.baz.footballapp.data.team.repository

import com.baz.footballapp.data.team.source.DummyDataSource
import kotlinx.coroutines.flow.flow

class TeamRepository {

    fun getTeams(query: String = "") = flow {
        if (query.isBlank()) {
            emit(DummyDataSource.dummyTeams)
        } else {
            val filteredTeams = DummyDataSource.dummyTeams.filter { team ->
                team.name.contains(
                    query,
                    ignoreCase = true
                )
            }
            emit(filteredTeams)
        }
    }

    fun getTeamById(id: Int) = flow {
        val team = DummyDataSource.dummyTeams.find { team -> team.id == id }
        emit(team)
    }
}