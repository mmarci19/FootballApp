package com.example.footballapp.ui.leagues

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.footballapp.model.league.League
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val leagueRepository: LeaguesRepository
) : ViewModel() {
    val leaguesList: Flow<List<League>> =
        leagueRepository.loadLeagues(
            onStart = { Log.d("Start","STARTED.")},
            onCompletion = { Log.d("Complete","COMPLETED")},
            onError = { Log.d("Error","ERROR") }
        )

}