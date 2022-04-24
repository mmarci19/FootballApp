package com.example.footballapp.ui.teams

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.footballapp.network.TeamService
import com.example.footballapp.persistence.TeamDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class TeamsRepository @Inject constructor(
    private val teamService: TeamService,
    private val teamDao: TeamDao
)
{
    fun getTeams(l_id: String) = flow {
        val teams = teamDao.getAllTeams(l_id)
        emit(teams)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun loadTeams(l_id: String,
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val teams = teamDao.getAllTeams(l_id)
        if (teams.isEmpty()) {
            var model = teamService.fetchTeamList("2021", l_id)
            Log.d("TAG",model.toString())

            for (response in model.responses) {
                response.team?.let { it.league_id = model.params?.league }
                response.team?.let { teamDao.insertTeam(it) }
                Log.d("TAG",response.team.toString())
            }

        } else {
            var model = teamService.fetchTeamList("2021", l_id)
            Log.d("TAG",model.toString())


            emit(teams)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)

}