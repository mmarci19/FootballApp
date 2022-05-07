package com.example.footballapp.network

import com.example.footballapp.model.details.TeamDetailModel
import com.example.footballapp.model.team.TeamModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TeamService {


    @Headers("X-RapidAPI-Key: 2d7a2452bemsh3484389efd7b45bp18adf9jsn27dfbe93b4d7", "Accept: application/json")@GET("teams")
suspend fun fetchTeamList(@Query("season") season: String, @Query("league") league: String): TeamModel

    @Headers("X-RapidAPI-Key: 2d7a2452bemsh3484389efd7b45bp18adf9jsn27dfbe93b4d7", "Accept: application/json")@GET("teams/statistics")
suspend fun fetchTeamStats(@Query("season") season: String, @Query("team") id_ : String, @Query("league") league: String): TeamDetailModel


}
