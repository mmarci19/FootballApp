package com.example.footballapp.network

import com.example.footballapp.model.Team
import com.example.footballapp.model.TeamModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TeamService {


    @Headers("X-RapidAPI-Key: 3af0cfc0e3msh1751c32679b8f64p1f6954jsn54fb0872207f", "Accept: application/json")@GET("teams")
suspend fun fetchTeamList(@Query("season") season: String, @Query("league") league: String): TeamModel

    @Headers("X-RapidAPI-Key: 3af0cfc0e3msh1751c32679b8f64p1f6954jsn54fb0872207f", "Accept: application/json")@GET("teams/statistics")
suspend fun fetchTeamStats(@Query("season") season: String, @Query("id") id_ : String, @Query("league") league: String): TeamModel


}
