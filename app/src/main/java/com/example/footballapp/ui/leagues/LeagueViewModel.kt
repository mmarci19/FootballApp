package com.example.footballapp.ui.leagues

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.footballapp.model.league.League
import com.example.footballapp.ui.teams.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject


@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val leagueRepository: LeaguesRepository,
) : ViewModel() {
    val leaguesList: Flow<List<League>> =
        leagueRepository.loadLeagues(
            onStart = { Log.d("INFO","STARTED.")},
            onCompletion = { Log.d("INFO","COMPLETED")},
            onError = { Log.d("INFO","ERROR") }
        )

    suspend fun Function(){
        Log.d("VIEWMODEL_TAG",leaguesList.first()[0].name!!)
        Log.d("VIEWMODEL_TAG",leaguesList.first()[1].name!!)
        Log.d("VIEWMODEL_TAG",leaguesList.first()[2].name!!)
    }



}
