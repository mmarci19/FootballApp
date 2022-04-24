package com.example.footballapp.network

import com.example.footballapp.model.league.Model
import retrofit2.http.*

interface LeagueService {

    @Headers("X-RapidAPI-Key: 3af0cfc0e3msh1751c32679b8f64p1f6954jsn54fb0872207f", "Accept: application/json")

    @GET("leagues")
    suspend fun fetchLeagueList(@Query("season") season: String, @Query("code") code: String, @Query("type") type: String): Model


    }
