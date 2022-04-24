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
    private val teamService: TeamService,
    private val teamDao: TeamDao
)
{
    var testVariable: TeamDetailModel = TeamDetailModel()
    fun getTeam(id: String) = flow {
        val teams = teamDao.getById(id.toLong())
        emit(teams)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun loadTeamById(id: String, l_id: String,
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow<TeamDetailModel> {

        var model = teamService.fetchTeamStats("2021",id,l_id)
            Log.d("TAG","IF AG")
            Log.d("TAG", model.toString())
            Log.d("TAG",model.params.toString())
            Log.d("TAG",model.get.toString())
            Log.d("TAG", model.toString())
            Log.d("TAG",model.responses.team.name.toString())
            Log.d("TAG",model.responses.league.name.toString())
            emit(model)

    }.onStart { Log.d("MSG","Start")}.onCompletion { Log.d("MSG","FINISH")}.flowOn(Dispatchers.IO)


}


