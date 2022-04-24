package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName

data class Goals (

    @SerializedName("for"              ) var scoredGoals             : Boolean? = null,
    @SerializedName("lineups"             ) var lineups            : Boolean? = null,
    @SerializedName("statistics_fixtures" ) var statisticsFixtures : Boolean? = null,
    @SerializedName("statistics_players"  ) var statisticsPlayers  : Boolean? = null

)