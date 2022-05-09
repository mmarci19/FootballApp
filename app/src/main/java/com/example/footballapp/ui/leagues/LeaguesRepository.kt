package com.example.footballapp.ui.leagues

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.footballapp.network.LeagueService
import com.example.footballapp.persistence.LeagueDao
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
        Log.d("ECHO","Itt vagyok.")
        val leagues = leagueDao.getAllLeagues()
        Log.d("TAG",leagues.toString())
        if (leagues.isEmpty()) {
            var model = leagueService.fetchLeagueList("2021","HU","League")
            Log.d("ECHO", model.toString())
            for (response in model.responses) {
                response.league?.let { leagueDao.insertLeague(it) }
                Log.d("ECHO LEAGUE",response.league.toString())

            }


        } else {
            var model = leagueService.fetchLeagueList("2021","HU","League")
            for (response in model.responses) {
                var league = response.league
                Log.d("TAG",league.toString())
            }
            emit(leagues)
        }
    Log.d("ECHO","Vegeztem.")
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}