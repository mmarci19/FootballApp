package com.example.footballapp.network

import com.example.footballapp.model.League
import com.example.footballapp.model.Team
import com.skydoves.sandwich.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface LeagueService {

    @Headers("X-RapidAPI-Key: 3af0cfc0e3msh1751c32679b8f64p1f6954jsn54fb0872207f")
    @GET("leagues")
    suspend fun fetchLeagueList(@Query("season") season: String, @Query("code") code: String, @Query("type") type: String): Call<List<League>>


    }