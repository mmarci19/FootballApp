package com.example.footballapp.ui.details

import com.example.footballapp.network.TeamService
import com.example.footballapp.persistence.TeamDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailRepository @Inject constructor(

    private val teamService: TeamService,
    private val teamDao: TeamDao
) {
   // fun getTeamById(id: Long) = flow {
  //  val team = teamDao.getById(id)
   //     emit(team)
   // }.flowOn(Dispatchers.IO)

}