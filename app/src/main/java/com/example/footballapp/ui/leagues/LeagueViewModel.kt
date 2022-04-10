package com.example.footballapp.ui.leagues

import androidx.lifecycle.ViewModel
import com.example.footballapp.ui.details.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject


@HiltViewModel
class LeagueViewModel @Inject constructor(
    //private val leagueRepository: LeaguesRepository
) : ViewModel() {

    //private val leagueIdSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow(replay = 1)

//    val leagueDetailsFlow = leagueIdSharedFlow.flatMapLatest {
  //      leagueRepository.getLeagueById(it)
   // }

    //fun loadLeagueById(id: Long) = leagueIdSharedFlow.tryEmit(id)
}