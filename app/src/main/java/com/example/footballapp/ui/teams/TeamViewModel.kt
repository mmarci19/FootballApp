package com.example.footballapp.ui.teams

import androidx.lifecycle.ViewModel
import com.example.footballapp.model.Team
import com.example.footballapp.ui.leagues.LeaguesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamsRepository: TeamsRepository
) : ViewModel() {

    val teamsList: Flow<List<Team>> =
        teamsRepository.loadTeams( "0",
            onStart = { },
            onCompletion = { },
            onError = {  }
        )

}