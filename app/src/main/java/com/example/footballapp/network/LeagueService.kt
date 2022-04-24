package com.example.footballapp.network

import com.example.footballapp.model.League
import com.example.footballapp.model.Model
import com.example.footballapp.model.Team
import com.skydoves.sandwich.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import com.example.footballapp.network.HeaderDescriptor
import retrofit2.http.*

interface LeagueService {

    @Headers("X-RapidAPI-Key: 3af0cfc0e3msh1751c32679b8f64p1f6954jsn54fb0872207f", "Accept: application/json")

    @GET("leagues")
    suspend fun fetchLeagueList(@Query("season") season: String, @Query("code") code: String, @Query("type") type: String): Model


    }
