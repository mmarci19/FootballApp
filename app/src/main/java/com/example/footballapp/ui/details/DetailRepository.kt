package com.example.footballapp.ui.details

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
import kotlinx.coroutines.Job
import javax.inject.Inject


class DetailRepository @Inject constructor(
    private val teamService: TeamService,
    private val teamDao: TeamDao
)
{
    private var teamID: String = "0"

    @WorkerThread
    fun loadTeamById(teamID: String) = flow {
        val team = teamDao.getById(teamID.toLong())
        emit(team)
    }.flowOn(Dispatchers.IO)


}