package com.example.footballapp.ui.details

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.footballapp.model.details.TeamDetailModel
import com.example.footballapp.model.team.Team
import com.example.footballapp.network.TeamService
import com.example.footballapp.persistence.TeamDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class DetailRepository @Inject constructor(
    private val teamService: TeamService
)
{
    @WorkerThread
    fun loadTeamById(id: String, l_id: String,
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow<TeamDetailModel> {

        var model = teamService.fetchTeamStats("2021",id,l_id)
        Log.d("ECHO", model.toString())
        emit(model)

    }.onStart { Log.d("INFO","Start")}.onCompletion { Log.d("INFO","FINISH")}.flowOn(Dispatchers.IO)


}


