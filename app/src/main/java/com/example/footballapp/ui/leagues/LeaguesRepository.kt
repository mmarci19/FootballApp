package com.example.footballapp.ui.leagues

import androidx.annotation.WorkerThread
import com.example.footballapp.model.League
import com.example.footballapp.model.Team
import com.example.footballapp.network.LeagueService
import com.example.footballapp.network.TeamService
import com.example.footballapp.persistence.LeagueDao
import com.example.footballapp.persistence.TeamDao
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class LeaguesRepository @Inject constructor(
    private val leagueService: LeagueService,
    private val leagueDao: LeagueDao

) {

    fun getLeagues() = flow {
        val teams = leagueDao.getAllLeagues()
        emit(teams)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun loadLeagues(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val teams: List<League> = leagueDao.getAllLeagues()
        if (teams.isEmpty()) {
            // request API network call asynchronously.
            leagueService.fetchLeagueList("2021","HU","League")

        } else {
            emit(teams)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)


}