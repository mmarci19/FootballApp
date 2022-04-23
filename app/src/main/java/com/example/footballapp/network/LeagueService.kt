package com.example.footballapp.network

import com.example.footballapp.model.League
import com.example.footballapp.model.Team
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface LeagueService {


    @GET("leagues")
    suspend fun fetchLeagueList(): ApiResponse<List<League>>

    }