package com.example.footballapp.di

import com.example.footballapp.network.LeagueService
import com.example.footballapp.network.TeamService
import com.example.footballapp.persistence.LeagueDao
import com.example.footballapp.persistence.TeamDao
import com.example.footballapp.ui.details.DetailRepository
import com.example.footballapp.ui.leagues.LeaguesRepository
import com.example.footballapp.ui.teams.TeamsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideDetailRepository(
        teamService: TeamService
    ): DetailRepository {
        return DetailRepository(teamService)
    }

    @Provides
    @ViewModelScoped
    fun provideTeamsRepository(
        teamService: TeamService,
        teamDao: TeamDao
    ): TeamsRepository {
        return TeamsRepository(teamService, teamDao)
    }

    @Provides
    @ViewModelScoped
    fun provideLeaguesRepository(
        leagueService: LeagueService,
        leagueDao: LeagueDao
    ): LeaguesRepository {
        return LeaguesRepository(leagueService, leagueDao)
    }
}