package com.example.footballapp.ui.teams

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.footballapp.model.team.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamsRepository: TeamsRepository
) : ViewModel() {

    private var league_id = "999"

    fun setLeagueId(id_: String){
        Log.d("ID-SET", id_)
        this.league_id = id_
    }

    lateinit var teamsList: Flow<List<Team>>

    fun forceTeamLoad(){
        teamsList = teamsRepository.loadTeams(this.league_id, //TODO: TEAM_ID, Will get from the user in runtime.
            onStart = { Log.d("Start","STARTED.")},
            onCompletion = { Log.d("Complete","COMPLETED")},
            onError = {
                Log.d(
                    "Error", "ERROR"
                )
            })
    }
}