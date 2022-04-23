package com.example.footballapp.network

import com.example.footballapp.model.Team
import com.skydoves.sandwich.ApiResponse

import retrofit2.http.GET

interface TeamService {

@GET("teams")
suspend fun fetchTeamList(): ApiResponse<List<Team>>

@GET("teams/statistics")
suspend fun fetchTeamStats(): ApiResponse<Team>

}