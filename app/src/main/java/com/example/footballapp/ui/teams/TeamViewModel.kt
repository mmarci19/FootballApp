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

    val teamsList: Flow<List<Team>> =
        teamsRepository.loadTeams( "271",
            onStart = { Log.d("Start","STARTED.")},
            onCompletion = { Log.d("Complete","COMPLETED")},
            onError = {
                Log.d(
                    "Error", "ERROR"
                )
            })
}