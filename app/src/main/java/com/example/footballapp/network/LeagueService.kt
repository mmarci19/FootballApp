package com.example.footballapp.network

import com.example.footballapp.model.league.Model
import retrofit2.http.*

interface LeagueService {

    @Headers("X-RapidAPI-Key: 2d7a2452bemsh3484389efd7b45bp18adf9jsn27dfbe93b4d7", "Accept: application/json")

    @GET("leagues")
    suspend fun fetchLeagueList(@Query("season") season: String, @Query("code") code: String, @Query("type") type: String): Model


    }
