package com.example.footballapp.ui.leagues

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.footballapp.model.League
import com.example.footballapp.model.Model
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
import retrofit2.Call
import retrofit2.Retrofit
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
        val leagues = leagueDao.getAllLeagues()
        if (leagues.isEmpty()) {
            var model = leagueService.fetchLeagueList("2021","HU","League")
            for (response in model.responses) {
                response.league?.let { leagueDao.insertLeague(it) }
                Log.d("TAG",response.league.toString())
            }


        } else {
            emit(leagues)
        }
        Log.d("Semmi", "SEMMI")
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}