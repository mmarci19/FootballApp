package com.example.footballapp.ui.leagues

import com.example.footballapp.network.LeagueService
import com.example.footballapp.persistence.LeagueDao
import com.example.footballapp.persistence.TeamDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LeaguesRepository @Inject constructor(



) {

    //fun getLeagueById(id: Long) = flow {
     //   val league = leagueDao.getById(id)
      //  emit(league)
    //}.flowOn(Dispatchers.IO)

    //fun getLeagues() = flow {
    //    val leagues = leagueDao.getAllLeagues()
    //    emit(leagues)
    //}.flowOn(Dispatchers.IO)

}