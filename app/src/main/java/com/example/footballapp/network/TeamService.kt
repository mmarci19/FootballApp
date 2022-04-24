package com.example.footballapp.network

import com.example.footballapp.model.Team
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TeamService {

@Headers("X-RapidAPI-Key: <key>")
  @GET("teams")
suspend fun fetchTeamList(@Query("season") season: String, @Query("code") code: String, @Query("type") type: String): Call<List<Team>>

@Headers("X-RapidAPI-Key: <key>")
  @GET("teams/statistics")
suspend fun fetchTeamStats(@Query("season") season: String, @Query("code") code: String, @Query("type") type: String, @Query("id") id_ : String): Call<Team>

}
