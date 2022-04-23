package com.example.footballapp.network

import com.example.footballapp.model.League
import com.example.footballapp.model.Team
import com.skydoves.sandwich.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LeagueService {


    @GET("leagues")
    suspend fun fetchLeagueList(@Query("season") season: String, @Query("code") code: String, @Query("type") type: String): Call<List<League>>


    }