package com.example.footballapp.ui.teams

import androidx.annotation.WorkerThread
import com.example.footballapp.model.Team
import com.example.footballapp.network.TeamService
import com.example.footballapp.persistence.TeamDao
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
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
        val teams: List<Team> = teamDao.getAllTeams(l_id)
        if (teams.isEmpty()) {
            // request API network call asynchronously.
            teamService.fetchTeamList("2021","HU","League", l_id)
            //TODO: handle successful request - insert into DB.
        } else {
            emit(teams)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)

}