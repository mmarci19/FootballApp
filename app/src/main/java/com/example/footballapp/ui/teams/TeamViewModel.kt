package com.example.footballapp.ui.teams

import androidx.lifecycle.ViewModel
import com.example.footballapp.ui.leagues.LeaguesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamsRepository: TeamsRepository
) : ViewModel() {

   private val teamIdSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow(replay = 1)

    val leagueDetailsFlow = teamIdSharedFlow.flatMapLatest {
        teamsRepository.getTeams()
    }

    fun loadLeagueById(id: Long) = teamIdSharedFlow.tryEmit(id)

}