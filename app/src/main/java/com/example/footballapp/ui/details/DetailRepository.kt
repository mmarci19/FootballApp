package com.example.footballapp.ui.details

import androidx.annotation.WorkerThread
import com.example.footballapp.model.League
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
import kotlinx.coroutines.Job
import javax.inject.Inject


class DetailRepository @Inject constructor(
    private val teamService: TeamService,
    private val teamDao: TeamDao
)
{

    fun getTeam(id: String) = flow {
        val teams = teamDao.getById(id.toLong())
        emit(teams)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun loadTeamById(id: String, l_id: String,
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val team: Team = teamDao.getById(id.toLong())
        var teams = listOf(team)

        if (teams.isEmpty()) {
            // request API network call asynchronously.
            val response = teamService.fetchTeamStats("2021","HU","League", id, l_id)

            //TODO: handle successful request - insert into DB.
        } else {
            emit(teams)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)

}