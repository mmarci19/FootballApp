package com.example.footballapp.model


import com.google.gson.annotations.SerializedName


data class Fixtures (

    @SerializedName("events"              ) var events             : Boolean? = null,
    @SerializedName("lineups"             ) var lineups            : Boolean? = null,
    @SerializedName("statistics_fixtures" ) var statisticsFixtures : Boolean? = null,
    @SerializedName("statistics_players"  ) var statisticsPlayers  : Boolean? = null

)